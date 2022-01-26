package com.lanceolata.code.snippets.spring.bean.definition;

import com.lanceolata.code.snippets.common.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例化
 */
public class BeanInstantiation {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        // 通过静态工厂方法
        User user = beanFactory.getBean("user-by-static-method", User.class);
        // 通过 Bean 工厂方法
        User userByInstanceMethod = beanFactory.getBean("user-by-instance-method", User.class);
        // 通过 FactoryBean
        User userByFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);

        System.out.println(user);
        System.out.println(userByInstanceMethod);
        System.out.println(userByFactoryBean);

        System.out.println(user == userByInstanceMethod);
        System.out.println(user == userByFactoryBean);
    }
}
