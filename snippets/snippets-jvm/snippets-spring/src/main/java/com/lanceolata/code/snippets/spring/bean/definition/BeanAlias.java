package com.lanceolata.code.snippets.spring.bean.definition;

import com.lanceolata.code.snippets.common.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean别名
 */
public class BeanAlias {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        // 通过别名 alias-user 获取曾用名 user 的 bean
        User user = beanFactory.getBean("user", User.class);
        User aliasUser = beanFactory.getBean("alias-user", User.class);
        System.out.println("aliasUser == user：" + (user == aliasUser));
    }
}
