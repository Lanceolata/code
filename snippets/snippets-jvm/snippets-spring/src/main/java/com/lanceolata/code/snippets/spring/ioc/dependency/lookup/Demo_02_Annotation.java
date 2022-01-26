package com.lanceolata.code.snippets.spring.ioc.dependency.lookup;

import com.lanceolata.code.snippets.common.annotation.Super;
import com.lanceolata.code.snippets.common.domain.SuperUser;
import com.lanceolata.code.snippets.common.domain.User;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import java.util.Map;

/**
 * 依赖查找 - 注解
 */
public class Demo_02_Annotation {

    public static void main(String[] args) {
        // 启动 Spring 应用上下文
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类作为配置类（Configuration Class）
        applicationContext.register(Demo_02_Annotation.class);
        // 启动应用上下文
        applicationContext.refresh();

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

        // 根据 ObjectProvider 查找
        lookupByObjectProvider(applicationContext);

        /**
         * =================================================
         * 集合类型依赖查找
         */
        // 根据 Bean 类型查找集合对象
        lookupCollectionByType(applicationContext);

        // 根据 注解 查找集合对象
        lookupByAnnotationType(applicationContext);

        applicationContext.close();
    }

    private static void lookupByName(ApplicationContext applicationContext) {
        User user = (User) applicationContext.getBean("annotationUser1");
        System.out.println("lookupByName：" + user);
    }

    private static void lookupByTypeInLazy(ApplicationContext applicationContext) {
        ObjectProvider<User> objectProvider = applicationContext.getBeanProvider(User.class);
        System.out.println("lookupByTypeInLazy：" + objectProvider.getObject());
    }

    private static void lookupByType(ApplicationContext applicationContext) {
        User user = applicationContext.getBean(User.class);
        System.out.println("lookupByType：" + user);
    }

    private static void lookupByNameAndType(ApplicationContext applicationContext) {
        User user = applicationContext.getBean("annotationUser1", User.class);
        System.out.println("lookupByNameAndType：" + user);
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

    private static void lookupByAnnotationType(ApplicationContext applicationContext) {
        if (applicationContext instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) applicationContext;

            // 获得 bean 名称
            String[] names = listableBeanFactory.getBeanNamesForAnnotation(Super.class);
            System.out.println("lookupByAnnotationType: " + String.join(",", names));

            // 获得 bean 名称 和 实例
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("lookupByAnnotationType：" + users);
        }
    }

    @Bean("annotationUser1")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("annotationUser1");
        return user;
    }

    @Bean("annotationUser2")
    @Primary
    @Lazy
    public User getUser2() {
        User user = new User();
        user.setId(2L);
        user.setName("annotationUser2");
        return user;
    }

    @Bean("annotationSuperUser1")
    public SuperUser getSuperUser() {
        SuperUser superUser = new SuperUser();
        superUser.setId(1L);
        superUser.setName("annotationSuperUser1");
        return superUser;
    }

}
