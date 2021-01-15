package com.lanceolata.code.snippets.core.util.mail;

import com.lanceolata.code.snippets.core.exception.MailException;
import com.lanceolata.code.snippets.core.util.mail.MailAttach;
import com.lanceolata.code.snippets.core.util.mail.MailMessage;
import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

/**
 * 发送邮件
 */
public class MailSender {
    private static final int DEFAULT_PORT = 25;
    private static final boolean DEFAULT_DEBUG = false;
    private static final String HTML_CONTENT_TYPE = "text/html;charset=utf-8";
    private static final String TEXT_CONTENT_TYPE = "text/plain;charset=utf-8";

    private String host;
    private int port;
    private boolean debug;

    private String username;
    private String password;

    public MailSender(String host, int port, boolean debug, String username, String password) {
        this.host = host;
        this.port = port;
        this.debug = debug;
        this.username = username;
        this.password = password;
    }

    public MailSender(String host) {
        this(host, DEFAULT_PORT, DEFAULT_DEBUG, null, null);
    }

    public MailSender(String host, String username, String password) {
        this(host, DEFAULT_PORT, DEFAULT_DEBUG, username, password);
    }

    public String send(MailMessage mailMessage) throws MailException {
        try {
            Session session = buildSession();
            MimeMessage message = buildMessage(session, mailMessage);
            Transport.send(message);
            return message.getMessageID();
        } catch (MessagingException e) {
            throw new MailException("Send Email Occur Exception ,Subject = " + mailMessage.subject, e);
        }
    }

    private Session buildSession() {
        Properties prop = buildProperties();
        Authenticator auth = buildAuthenticator(prop);
        return Session.getInstance(prop, auth);
    }

    private Properties buildProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        prop.put("mail.debug", debug ? "true" : "false");
        return prop;
    }

    private Authenticator buildAuthenticator(Properties prop) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            prop.put("mail.smtp.auth", "false");
            return null;
        } else {
            prop.put("mail.smtp.auth", "true");
            return new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };
        }
    }

    private MimeMessage buildMessage(Session session, MailMessage mailMessage) throws MessagingException {
        MimeMessage message = new MimeMessage(session);
        MimeMultipart multipart = new MimeMultipart();

        //from
        Address from = new InternetAddress(mailMessage.from);
        message.setFrom(from);

        // to
        Address[] toAddresses = InternetAddress.parse(StringUtils.join(mailMessage.to, ","));
        message.setRecipients(Message.RecipientType.TO, toAddresses);

        // cc
        if (ArrayUtils.isNotEmpty(mailMessage.cc)) {
            Address[] ccAddresses = InternetAddress.parse(StringUtils.join(mailMessage.cc, ","));
            message.setRecipients(Message.RecipientType.CC, ccAddresses);
        }

        // bcc
        if (ArrayUtils.isNotEmpty(mailMessage.bcc)) {
            Address[] bccAddresses = InternetAddress.parse(StringUtils.join(mailMessage.bcc, ","));
            message.setRecipients(Message.RecipientType.BCC, bccAddresses);
        }

        // date
        message.setSentDate(new Date());

        // subject
        message.setSubject(mailMessage.subject);

        //邮件正文
        BodyPart bodyPart = new MimeBodyPart();
        if (mailMessage.html) {
            bodyPart.setContent(mailMessage.content, HTML_CONTENT_TYPE);
        } else {
            bodyPart.setText(mailMessage.content);
        }
        multipart.addBodyPart(bodyPart);

        //添加附件
        if (ArrayUtils.isNotEmpty(mailMessage.mailAttaches)) {
            MimeBodyPart attachBodyPart = null;
            for (MailAttach attach : mailMessage.mailAttaches) {
                attachBodyPart = new MimeBodyPart();
                attachBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(attach.getBytes(), attach.getType())));
                attachBodyPart.setFileName(attach.getName());
                if (StringUtils.isNotBlank(attach.getCid())) {
                    attachBodyPart.setContentID(attach.getCid());
                }
                multipart.addBodyPart(attachBodyPart);
            }
        }

        message.setContent(multipart);
        message.saveChanges();

        return message;
    }
}
