package com.lanceolata.code.snippets.common.java.util.mail;

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
        return this.name;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public String getType() {
        return this.type;
    }

    public String getCid() {
        return this.cid;
    }
}
