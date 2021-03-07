package com.lanceolata.code.snippets.dao.entity.test;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

public class TagHll {
    private Long id;
    private String key;
    private String value;
    private byte[] hll;
    private Long version;
    private String table;
    private Timestamp updateTime;

    public TagHll() {
    }

    public TagHll(String key, String value, byte[] hll, Long version, String table) {
        this.key = key;
        this.value = value;
        this.hll = hll;
        this.version = version;
        this.table = table;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagHll tagHll = (TagHll) o;
        return Objects.equals(id, tagHll.id) &&
                Objects.equals(key, tagHll.key) &&
                Objects.equals(value, tagHll.value) &&
                Arrays.equals(hll, tagHll.hll) &&
                Objects.equals(version, tagHll.version) &&
                Objects.equals(table, tagHll.table) &&
                Objects.equals(updateTime, tagHll.updateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, key, value, version, table, updateTime);
        result = 31 * result + Arrays.hashCode(hll);
        return result;
    }

    @Override
    public String toString() {
        return "TagHll{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", hll=" + Arrays.toString(hll) +
                ", version=" + version +
                ", table='" + table + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
