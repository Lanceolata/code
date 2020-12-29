package com.lanceolata.code.snippets.common.java.util.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;
import javax.activation.MimetypesFileTypeMap;

import com.lanceolata.code.snippets.common.java.exception.MailException;
import org.apache.commons.io.IOUtils;

public final class MailMessage {
    final String subject;
    final String content;
    final String[] to;
    final String[] cc;
    final String[] bcc;
    final String from;
    final boolean html;
    final MailAttach[] mailAttaches;

    MailMessage(MailMessage.Builder builder) {
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
        }

        public MailMessage.Builder subject(String subject) throws MailException {
            if (this.isBlank(subject)) {
                throw new MailException("Mail Subject Can Not Be Null Or Empty");
            } else {
                this.subject = subject;
                return this;
            }
        }

        public MailMessage.Builder content(String content) throws MailException {
            if (this.isBlank(content)) {
                throw new MailException("Mail Content Can Not Be Null Or Empty");
            } else {
                this.content = content;
                return this;
            }
        }

        public MailMessage.Builder to(String[] to) throws MailException {
            if (!this.isEmpty(to)) {
                String[] var2 = to;
                int var3 = to.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    String t = var2[var4];
                    this.to(t);
                }
            }

            return this;
        }

        public MailMessage.Builder to(String to) throws MailException {
            if (!this.isMailAddress(to)) {
                throw new MailException("Email Address is Illegal：" + to);
            } else {
                if (this.isEmpty(this.to)) {
                    this.to = new String[]{to};
                } else {
                    this.to = this.addOne(this.to, to);
                }

                return this;
            }
        }

        public MailMessage.Builder cc(String[] cc) throws MailException {
            if (!this.isEmpty(cc)) {
                String[] var2 = cc;
                int var3 = cc.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    String c = var2[var4];
                    this.cc(c);
                }
            }

            return this;
        }

        public MailMessage.Builder cc(String cc) throws MailException {
            if (!this.isMailAddress(cc)) {
                throw new MailException("Email Address is Illegal：" + cc);
            } else {
                if (this.isEmpty(this.cc)) {
                    this.cc = new String[]{cc};
                } else {
                    this.cc = this.addOne(this.cc, cc);
                }

                return this;
            }
        }

        public MailMessage.Builder bcc(String[] bcc) throws MailException {
            if (!this.isEmpty(bcc)) {
                String[] var2 = bcc;
                int var3 = bcc.length;

                for(int var4 = 0; var4 < var3; ++var4) {
                    String c = var2[var4];
                    this.bcc(c);
                }
            }

            return this;
        }

        public MailMessage.Builder bcc(String bcc) throws MailException {
            if (!this.isMailAddress(bcc)) {
                throw new MailException("Email Address is Illegal：" + bcc);
            } else {
                if (this.isEmpty(this.bcc)) {
                    this.bcc = new String[]{bcc};
                } else {
                    this.bcc = this.addOne(this.bcc, bcc);
                }

                return this;
            }
        }

        public MailMessage.Builder from(String from) throws MailException {
            if (this.isBlank(from)) {
                throw new MailException("Mail From Can Not Be Null Or Empty");
            } else {
                this.from = from;
                return this;
            }
        }

        public MailMessage.Builder html(boolean html) {
            this.html = html;
            return this;
        }

        public MailMessage.Builder attach(MailAttach attach) {
            if (this.isEmpty(this.mailAttaches)) {
                this.mailAttaches = new MailAttach[]{attach};
            } else {
                this.mailAttaches = this.addOne(this.mailAttaches, attach);
            }

            return this;
        }

        public MailMessage.Builder attach(String attachName, byte[] bytes, String type, String cid) {
            return this.attach(new MailAttach(attachName, bytes, type, cid));
        }

        public MailMessage.Builder attach(String filePath, String cid) throws MailException {
            return this.attach(new File(filePath), cid);
        }

        public MailMessage.Builder attach(File file, String cid) throws MailException {
            try {
                return this.attach(file.getName(), IOUtils.toByteArray(new FileInputStream(file)), (new MimetypesFileTypeMap()).getContentType(file), cid);
            } catch (IOException var4) {
                throw new MailException("File Not Found : " + file.getAbsolutePath(), var4);
            }
        }

        public MailMessage.Builder attach(String fileName, InputStream inputStream, String type, String cid) throws MailException {
            try {
                return this.attach(fileName, IOUtils.toByteArray(inputStream), type, cid);
            } catch (IOException var6) {
                throw new MailException("File Not Found : " + fileName, var6);
            }
        }

        public MailMessage build() throws MailException {
            if (this.isBlank(this.subject)) {
                throw new MailException("Mail Subject Can Not Be Null Or Empty");
            } else if (this.isBlank(this.content)) {
                throw new MailException("Mail Content Can Not Be Null Or Empty");
            } else if (this.isEmpty(this.to) && this.isEmpty(this.cc) && this.isEmpty(this.bcc)) {
                throw new MailException("Mail Recipients Can Not Be Null Or Empty");
            } else {
                return new MailMessage(this);
            }
        }

        private boolean isBlank(String text) {
            return text == null || text.trim().length() == 0;
        }

        private boolean isEmpty(Object[] arr) {
            return arr == null || arr.length == 0;
        }

        private boolean isMailAddress(String mailAddr) {
            return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", mailAddr);
        }

        private String[] addOne(String[] origin, String no) {
            String[] newArray = new String[origin.length + 1];
            System.arraycopy(origin, 0, newArray, 0, origin.length);
            newArray[newArray.length - 1] = no;
            return newArray;
        }

        private MailAttach[] addOne(MailAttach[] origin, MailAttach no) {
            MailAttach[] newArray = new MailAttach[origin.length + 1];
            System.arraycopy(origin, 0, newArray, 0, origin.length);
            newArray[newArray.length - 1] = no;
            return newArray;
        }
    }
}
