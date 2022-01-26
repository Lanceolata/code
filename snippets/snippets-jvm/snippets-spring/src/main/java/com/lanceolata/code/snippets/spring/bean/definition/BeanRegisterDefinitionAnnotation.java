package com.lanceolata.code.snippets.spring.bean.definition;

import com.lanceolata.code.snippets.common.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * 注解 注册 BeanDefinition
 */
@Import(BeanRegisterDefinitionAnnotation.Config.class) // 3. 通过 @Import 来进行导入
public class BeanRegisterDefinitionAnnotation {
    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class（配置类）
        applicationContext.register(Config.class);
        // 1. 通过 @Bean 方式定义
        // 2. 通过 @Component 方式定义
        // 3. 通过 @Import 方式定义

        // 启动 Spring 应用上下文
        applicationContext.refresh();
        System.out.println("Config 类型的所有 Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有 Beans" + applicationContext.getBeansOfType(User.class));

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Component // 2. 通过 @Component 方式
    public static class Config {
        @Bean(name = {"user", "alias-user"}) // 1. 通过 @Bean 方式定义
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("小马哥");
            return user;
        }
    }
}
