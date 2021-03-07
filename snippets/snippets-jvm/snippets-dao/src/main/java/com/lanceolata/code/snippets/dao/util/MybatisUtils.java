package com.lanceolata.code.snippets.dao.util;

import com.google.common.collect.Maps;
import com.lanceolata.code.snippets.core.common.Constants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.Properties;

/**
 * Mybatis工具类
 */
public class MybatisUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisUtils.class);

    private static Map<String, SqlSessionFactory> sqlSessionFactoryMap = Maps.newHashMap();
    private static String defaultEnv;

    static {
        // 优先使用系统变量
        defaultEnv = System.getProperty(Constants.PROPERTY_KEY_MYBATIS_ENV);
        if (defaultEnv == null) {
            try {
                Properties properties = new Properties();
                properties.load(MybatisUtils.class.getClassLoader().getResourceAsStream("application.properties"));
                defaultEnv = properties.getProperty(Constants.PROPERTY_KEY_MYBATIS_ENV);
            } catch (Exception e) {
                LOGGER.warn("load application.properties failed.", e);
            }
        }
    }

    /**
     * 获得Mybatis Mapper
     * 从包名获取DB名称
     * 使用默认env
     *
     * @param mapperClass
     * @param <M>
     * @return
     */
    public static synchronized <M> M getMapper(Class<M> mapperClass) throws IOException {
        String dbName = getDBNameFromPackage(mapperClass);
        return getMapper(mapperClass, dbName, defaultEnv);
    }

    /**
     * 获得Mybatis Mapper
     * 使用默认env
     *
     * @param mapperClass
     * @param dbName
     * @param <M>
     * @return
     * @throws IOException
     */
    public static <M> M getMapper(Class<M> mapperClass, String dbName) throws IOException {
        return getMapper(mapperClass, dbName, defaultEnv);
    }

    /**
     * 获得Mybatis Mapper
     *
     * @param mapperClass
     * @param dbName
     * @param env
     * @param <M>
     * @return
     * @throws IOException
     */
    public static synchronized <M> M getMapper(Class<M> mapperClass, String dbName, String env) throws IOException {
        String dbMapKey = getDBKey(dbName, env);
        if (!sqlSessionFactoryMap.containsKey(dbMapKey)) {
            InputStream resourceStream = Resources.getResourceAsStream("mybatis-config_" + dbName + ".xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceStream, env);
            sqlSessionFactoryMap.put(dbMapKey, sqlSessionFactory);
        }
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryMap.get(dbMapKey);
        return (M)Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class<?>[]{mapperClass}, new MapperInvocationHandler(mapperClass, sqlSessionFactory));
    }

    /**
     * 生成数据库标识key
     *
     * @param dbName
     * @param env
     * @return
     */
    private static String getDBKey(String dbName, String env) {
        return dbName + "@" + env;
    }

    /**
     * 从包名中获取DB名称
     *
     * @param mapperClass
     * @return
     */
    private static String getDBNameFromPackage(Class mapperClass) {
        String packageName = mapperClass.getPackage().getName();
        String[] ps = packageName.split("\\.");
        return ps[ps.length - 1];
    }

    public static class MapperInvocationHandler<M> implements InvocationHandler {
        private Class<M> mapperClass;
        private SqlSessionFactory sqlSessionFactory;

        public MapperInvocationHandler(Class<M> mapperClass, SqlSessionFactory sqlSessionFactory) {
            this.mapperClass = mapperClass;
            this.sqlSessionFactory = sqlSessionFactory;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            SqlSession session = sqlSessionFactory.openSession();
            M mapper = session.getMapper(mapperClass);
            Object result = method.invoke(mapper, args);
            session.commit();
            session.close();
            return result;
        }
    }
}
