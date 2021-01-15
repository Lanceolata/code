package com.lanceolata.code.snippets.core.util.mail;

import java.util.Arrays;

/**
 * 邮件附件
 */
public class MailAttach {
    private String name;
    private byte[] bytes;
    private String type;
    private String cid;

    public MailAttach(String name, byte[] bytes, String type) {
        this.name = name;
        this.bytes = bytes;
        this.type = type;
    }

    public MailAttach(String name, byte[] bytes, String type, String cid) {
        this.name = name;
        this.bytes = bytes;
        this.type = type;
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "MailAttach{" +
                "name='" + name + '\'' +
                ", bytes=" + Arrays.toString(bytes) +
                ", type='" + type + '\'' +
                ", cid='" + cid + '\'' +
                '}';
    }
}
