package com.lanceolata.code.snippets.spring.ioc.dependency.lookup;

import com.lanceolata.code.snippets.common.domain.SuperUser;
import com.lanceolata.code.snippets.common.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找 - xml
 */
public class Demo_01_Xml {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");

        /**
         * =================================================
         * 单一类型依赖查找
         */
        // 根据 Bean 名称查找 - 实时
        lookupByName(applicationContext);
        // 根据 Bean 类型查找 - 延迟
        lookupByTypeInLazy(applicationContext);
        // 根据 Bean 类型查找 - 实时
        lookupByType(applicationContext);
        // 根据 Bean 名称 + 类型查找
        lookupByNameAndType(applicationContext);

        // 根据 ObjectFactory 查找 实现延迟初始化
        lookupByObjectFactory(applicationContext);

        // xml 继承
        lookupInheritByNameAndType(applicationContext);

        // 根据 ObjectProvider 查找
        lookupByObjectProvider(applicationContext);

        /**
         * =================================================
         * 集合类型依赖查找
         */
        // 根据 Bean 类型查找集合对象
        lookupCollectionByType(applicationContext);

        applicationContext.close();
    }

    private static void lookupByName(ApplicationContext applicationContext) {
        User xmlUser1 = (User) applicationContext.getBean("xmlUser1");
        System.out.println("lookupByName：" + xmlUser1);
    }

    private static void lookupByTypeInLazy(ApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);
        System.out.println("lookupByTypeInLazy: " + objectProvider.getObject());
    }

    private static void lookupByType(ApplicationContext applicationContext) {
        User user = applicationContext.getBean(User.class);
        System.out.println("lookupByType：" + user);
    }

    private static void lookupByNameAndType(ApplicationContext applicationContext) {
        User xmlUser1 = applicationContext.getBean("xmlUser1", User.class);
        System.out.println("lookupByNameAndType：" + xmlUser1);
    }

    private static void lookupByObjectFactory(ApplicationContext applicationContext) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) applicationContext.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("lookupByObjectFactory：" + user);
    }

    private static void lookupInheritByNameAndType(ApplicationContext applicationContext) {
        SuperUser superUser = applicationContext.getBean("xmlSupperUser1", SuperUser.class);
        System.out.println("lookupInheritByNameAndType：" + superUser);
    }

    private static void lookupByObjectProvider(ApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);

        User user = objectProvider.getIfAvailable(User::createUser);
        System.out.println("lookupByObjectProvider：" + user);

        objectProvider.stream().forEach(System.out::println);
    }

    private static void lookupCollectionByType(ApplicationContext applicationContext) {
        if (applicationContext instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) applicationContext;

            // 获得 bean 名称
            String[] names = listableBeanFactory.getBeanNamesForType(User.class);
            System.out.println("lookupCollectionByType: " + String.join(",", names));

            // 获得 bean 名称 和 实例
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupCollectionByType：" + users);
        }
    }

}
