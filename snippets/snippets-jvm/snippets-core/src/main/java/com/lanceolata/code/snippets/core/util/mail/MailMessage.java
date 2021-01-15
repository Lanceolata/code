package com.lanceolata.code.snippets.core.util.mail;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;
import javax.activation.MimetypesFileTypeMap;

import com.lanceolata.code.snippets.core.exception.MailException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 邮件
 */
public final class MailMessage {
    final String subject;
    final String content;
    final String[] to;
    final String[] cc;
    final String[] bcc;
    final String from;
    final boolean html;
    final MailAttach[] mailAttaches;

    MailMessage(Builder builder) {
        this.subject = builder.subject;
        this.content = builder.content;
        this.to = builder.to;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.from = builder.from;
        this.html = builder.html;
        this.mailAttaches = builder.mailAttaches;
    }

    public static final class Builder {
        private static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

        private String subject;
        private String content;
        private String[] to;
        private String[] cc;
        private String[] bcc;
        private String from;
        private boolean html;
        private MailAttach[] mailAttaches;

        public Builder() {
            this.html = true;
        }

        Builder(MailMessage message) {
            this.subject = message.subject;
            this.content = message.content;
            this.to = message.to;
            this.cc = message.cc;
            this.bcc = message.bcc;
            this.from = message.from;
            this.html = message.html;
            this.mailAttaches = message.mailAttaches;
        }

        public Builder subject(String subject) throws MailException {
            if (StringUtils.isBlank(subject)) {
                throw new MailException("Mail Subject Can Not Be Null Or Empty");
            }
            this.subject = subject;
            return this;
        }

        public Builder content(String content) throws MailException {
            if (StringUtils.isBlank(content)) {
                throw new MailException("Mail Content Can Not Be Null Or Empty");
            }
            this.content = content;
            return this;
        }

        public Builder to(String to) throws MailException {
            if (!isMailAddress(to)) {
                throw new MailException("Email Address is Illegal：" + to);
            }
            this.to = ArrayUtils.add(this.to, to);
            return this;
        }

        public Builder to(String[] to) throws MailException {
            if (ArrayUtils.isNotEmpty(to)) {
                for (String t : to) {
                    to(t);
                }
            }
            return this;
        }

        public Builder cc(String cc) throws MailException {
            if (!isMailAddress(cc)) {
                throw new MailException("Email Address is Illegal：" + cc);
            }
            this.cc = ArrayUtils.add(this.cc, cc);
            return this;
        }

        public Builder cc(String[] cc) throws MailException {
            if (ArrayUtils.isNotEmpty(cc)) {
                for (String c : cc) {
                    cc(c);
                }
            }
            return this;
        }

        public Builder bcc(String bcc) throws MailException {
            if (!isMailAddress(bcc)) {
                throw new MailException("Email Address is Illegal：" + bcc);
            }
            this.bcc = ArrayUtils.add(this.bcc, bcc);
            return this;
        }

        public Builder bcc(String[] bcc) throws MailException {
            if (ArrayUtils.isNotEmpty(bcc)) {
                for (String b : bcc) {
                    bcc(b);
                }
            }
            return this;
        }

        public Builder from(String from) throws MailException {
            if (StringUtils.isBlank(from)) {
                throw new MailException("Mail From Can Not Be Null Or Empty");
            }
            this.from = from;
            return this;
        }

        public Builder html(boolean html) {
            this.html = html;
            return this;
        }

        public Builder attach(MailAttach attach) {
            this.mailAttaches = ArrayUtils.add(this.mailAttaches, attach);
            return this;
        }

        public Builder attach(String attachName, byte[] bytes, String type, String cid) {
            return attach(new MailAttach(attachName, bytes, type, cid));
        }

        public Builder attach(String fileName, InputStream inputStream, String type, String cid) throws MailException {
            try {
                return this.attach(fileName, IOUtils.toByteArray(inputStream), type, cid);
            } catch (IOException var6) {
                throw new MailException("File Not Found : " + fileName, var6);
            }
        }

        public Builder attach(File file, String cid) throws MailException {
            try {
                return attach(file.getName(), new FileInputStream(file), (new MimetypesFileTypeMap()).getContentType(file), cid);
            } catch (FileNotFoundException e) {
                throw new MailException("File Not Found : " + file.getAbsolutePath(), e);
            }

        }

        public Builder attach(String filePath, String cid) throws MailException {
            return attach(new File(filePath), cid);
        }

        public MailMessage build() throws MailException {
            if (StringUtils.isEmpty(this.subject)) {
                throw new MailException("Mail Subject Can Not Be Null Or Empty");
            }
            if (StringUtils.isEmpty(this.content)) {
                throw new MailException("Mail Content Can Not Be Null Or Empty");
            }
            if (ArrayUtils.isEmpty(this.to) && ArrayUtils.isEmpty(this.cc) && ArrayUtils.isEmpty(this.bcc)) {
                throw new MailException("Mail Recipients Can Not Be Null Or Empty");
            }
            return new MailMessage(this);
        }

        private boolean isMailAddress(String mailAddr) {
            return Pattern.matches(REGEX_EMAIL, mailAddr);
        }
    }

    @Override
    public String toString() {
        return "MailMessage{" +
                "subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", to=" + Arrays.toString(to) +
                ", cc=" + Arrays.toString(cc) +
                ", bcc=" + Arrays.toString(bcc) +
                ", from='" + from + '\'' +
                ", html=" + html +
                ", mailAttaches=" + Arrays.toString(mailAttaches) +
                '}';
    }
}
