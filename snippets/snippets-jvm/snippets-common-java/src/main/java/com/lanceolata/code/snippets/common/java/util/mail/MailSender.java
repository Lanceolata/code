package com.lanceolata.code.snippets.common.java.util.mail;

import com.lanceolata.code.snippets.common.java.exception.MailException;
import com.sun.mail.smtp.SMTPTransport;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import org.apache.commons.lang.StringUtils;

public class MailSender {
    private String host;
    private String token;
    private Session session;
    private static final String HTML_CONTENT_TYPE = "text/html;charset=utf-8";

    public MailSender(String host, String token) throws MailException {
        this.host = host;
        this.token = token;
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "false");
        properties.setProperty("mail.transport.protocol", "smtp");

        try {
            this.session = Session.getDefaultInstance(properties);
        } catch (Exception var5) {
            throw new MailException("Can Not Create Session With Mail Server", var5);
        }
    }

    public MailSender(String host) throws MailException {
        this(host, (String)null);
    }

    public String send(MailMessage mailMessage) throws MailException {
        MimeMessage message = new MimeMessage(this.session);
        MimeMultipart multipart = new MimeMultipart();

        try {
            String from = mailMessage.from;
            this.token = from != null && from.trim().length() > 0 ? from : this.token;
            message.setFrom(new InternetAddress(this.token));
            String[] var5;
            int var6;
            int var7;
            String bcc;
            if (mailMessage.to != null) {
                var5 = mailMessage.to;
                var6 = var5.length;

                for(var7 = 0; var7 < var6; ++var7) {
                    bcc = var5[var7];
                    message.addRecipient(RecipientType.TO, new InternetAddress(bcc));
                }
            }

            if (mailMessage.cc != null) {
                var5 = mailMessage.cc;
                var6 = var5.length;

                for(var7 = 0; var7 < var6; ++var7) {
                    bcc = var5[var7];
                    message.addRecipient(RecipientType.CC, new InternetAddress(bcc));
                }
            }

            if (mailMessage.bcc != null) {
                var5 = mailMessage.bcc;
                var6 = var5.length;

                for(var7 = 0; var7 < var6; ++var7) {
                    bcc = var5[var7];
                    message.addRecipient(RecipientType.BCC, new InternetAddress(bcc));
                }
            }

            message.setSubject(mailMessage.subject);
            BodyPart bodyPart = new MimeBodyPart();
            if (mailMessage.html) {
                bodyPart.setContent(mailMessage.content, "text/html;charset=utf-8");
            } else {
                bodyPart.setText(mailMessage.content);
            }

            multipart.addBodyPart(bodyPart);
            if (mailMessage.mailAttaches != null) {
                MimeBodyPart attachBodyPart = null;
                MailAttach[] var15 = mailMessage.mailAttaches;
                int var16 = var15.length;

                for(int var9 = 0; var9 < var16; ++var9) {
                    MailAttach attach = var15[var9];
                    String cid = attach.getCid();
                    attachBodyPart = new MimeBodyPart();
                    attachBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(attach.getBytes(), attach.getType())));
                    attachBodyPart.setFileName(attach.getName());
                    if (StringUtils.isNotBlank(cid)) {
                        attachBodyPart.setContentID(cid);
                    }

                    multipart.addBodyPart(attachBodyPart);
                }
            }

            message.setContent(multipart);
            return this.send(message);
        } catch (Exception var12) {
            throw new MailException("Send Email Occur Exception ,Subject = " + mailMessage.subject, var12);
        }
    }

    public String send(String subject, String content, String... to) throws MailException {
        MimeMessage message = new MimeMessage(this.session);
        MimeMultipart multipart = new MimeMultipart();

        try {
            message.setFrom(new InternetAddress(this.token));
            String[] var6 = to;
            int var7 = to.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                String t = var6[var8];
                message.addRecipient(RecipientType.TO, new InternetAddress(t));
            }

            message.setSubject(subject);
            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(content, "text/html;charset=utf-8");
            multipart.addBodyPart(bodyPart);
            message.setContent(multipart);
            return this.send(message);
        } catch (Exception var10) {
            throw new MailException("Send Email Occur Exception ,Subject = " + subject, var10);
        }
    }

    private String send(MimeMessage message) throws MessagingException, IOException {
        SMTPTransport transport = (SMTPTransport)this.session.getTransport();
        transport.setLocalHost("127.0.0.1");
        transport.connect(new Socket(this.host, 25));
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        return message.getMessageID();
    }
}
