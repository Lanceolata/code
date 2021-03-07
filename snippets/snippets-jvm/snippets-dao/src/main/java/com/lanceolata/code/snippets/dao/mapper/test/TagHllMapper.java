package com.lanceolata.code.snippets.dao.mapper.test;

import com.lanceolata.code.snippets.dao.entity.test.TagHll;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagHllMapper {
    @Insert("<script>" +
            "replace into `xxx` (`key`, `value`, `hll`, `version`, `table`) values " +
            "<foreach collection ='tagHllList' item='th' separator =','> (#{th.key}, #{th.value}, #{th.hll}, #{th.version}, #{th.table}) </foreach >" +
            "</script>")
    void insertBatch(@Param("tagHllList") List<TagHll> tagHllList);

    @Delete("delete from `xxx` where `table` = #{table} and `version` < #{version}")
    void deleteHistoryByTableVersion(@Param("table") String table, @Param("version") Long version);

    @Select("select * from xxx where `key` = #{key} and `value` = #{value}")
    TagHll selectByKeyAndValue(@Param("key") String key, @Param("value") String value);
}
