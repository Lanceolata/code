package com.lanceolata.code.snippets.dao.mapper.test;

import com.lanceolata.code.snippets.dao.entity.test.TagHll;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagHllMapper {
    @Insert("<script>" +
            "replace into `xxx` (`tag_code`, `tag_value`, `hll`, `version`, `table_mark`) values " +
            "<foreach collection ='tagHllList' item='th' separator =','> (#{th.tagCode}, #{th.tagValue}, #{th.hll}, #{th.version}, #{th.tableMark}) </foreach >" +
            "</script>")
    void insertBatch(@Param("tagHllList") List<TagHll> tagHllList);

    @Delete("delete from `xxx` where `table_mark` = #{tableMark} and `version` < #{version}")
    void deleteHistoryByTableMarkAndVersion(@Param("tableMark") String tableMark, @Param("version") Long version);

    @Select("select * from xxx where `tag_code` = #{tagCode}")
    List<TagHll> selectByTagCode(@Param("tagCode") String tagCode);

    @Select("select * from xxx where `tag_code` = #{tagCode} and `tag_value` = #{tagValue}")
    TagHll selectByTagCodeAndTagValue(@Param("tagCode") String tagCode, @Param("tagValue") String tagValue);

    @Select("<script>" +
            "select * from xxx where " +
            "<foreach collection ='tagHllList' item='th' separator ='or'> (`tag_code` = #{th.tagCode} and `tag_value` = #{th.tagValue}) </foreach >" +
            "</script>")
    List<TagHll> selectByTagCodeAndTagValueBatch(@Param("tagHllList") List<TagHll> tagHllList);
}
