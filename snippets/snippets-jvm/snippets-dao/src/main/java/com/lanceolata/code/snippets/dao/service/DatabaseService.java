package com.lanceolata.code.snippets.dao.service;

import com.lanceolata.code.snippets.dao.mapper.test.TagHllMapper;
import com.lanceolata.code.snippets.dao.util.MybatisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 数据库
 */
public class DatabaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseService.class);

    private static class TagHllMapperInstance {
        private static TagHllMapper tagHllMapper;

        static {
            try {
                tagHllMapper = MybatisUtils.getMapper(TagHllMapper.class);
            } catch (IOException e) {
                LOGGER.error("get mapper failed.", e);
                throw new RuntimeException(e);
            }
        }
    }

    public static TagHllMapper getTagHllMapper() {
        return TagHllMapperInstance.tagHllMapper;
    }
}
