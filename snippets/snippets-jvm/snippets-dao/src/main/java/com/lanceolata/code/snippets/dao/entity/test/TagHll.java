package com.lanceolata.code.snippets.dao.entity.test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

public class TagHll {
    private Long id;
    private String tagCode;
    private String tagValue;
    private byte[] hll;
    private Long version;
    private String tableMark;
    private Timestamp updateTime;

    public TagHll() {
    }

    public TagHll(String tagCode, String tagValue) {
        this.tagCode = tagCode;
        this.tagValue = tagValue;
    }

    public TagHll(String tagCode, String tagValue, byte[] hll, Long version, String tableMark) {
        this.tagCode = tagCode;
        this.tagValue = tagValue;
        this.hll = hll;
        this.version = version;
        this.tableMark = tableMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagHll tagHll = (TagHll) o;
        return Objects.equals(id, tagHll.id) &&
                Objects.equals(tagCode, tagHll.tagCode) &&
                Objects.equals(tagValue, tagHll.tagValue) &&
                Arrays.equals(hll, tagHll.hll) &&
                Objects.equals(version, tagHll.version) &&
                Objects.equals(tableMark, tagHll.tableMark) &&
                Objects.equals(updateTime, tagHll.updateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, tagCode, tagValue, version, tableMark, updateTime);
        result = 31 * result + Arrays.hashCode(hll);
        return result;
    }

    @Override
    public String toString() {
        return "TagHll{" +
                "id=" + id +
                ", tagCode='" + tagCode + '\'' +
                ", tagValue='" + tagValue + '\'' +
                ", hll=" + Arrays.toString(hll) +
                ", version=" + version +
                ", tableMark='" + tableMark + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagCode() {
        return tagCode;
    }

    public void setTagCode(String tagCode) {
        this.tagCode = tagCode;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    public byte[] getHll() {
        return hll;
    }

    public void setHll(byte[] hll) {
        this.hll = hll;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getTableMark() {
        return tableMark;
    }

    public void setTableMark(String tableMark) {
        this.tableMark = tableMark;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
