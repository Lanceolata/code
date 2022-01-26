package com.lanceolata.code.snippets.spring.ioc.dependency;

import com.lanceolata.code.snippets.common.domain.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入示例
 */
public class DependencySource {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-source-context.xml");

        // 依赖注入来源
        injectSource(applicationContext);
    }

    private static void injectSource(ApplicationContext applicationContext) {
        // 依赖来源一：自定义 Bean
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        System.out.println(userRepository.getUsers());

        // 依赖来源二：依赖注入（內建依赖）
        System.out.println(userRepository.getBeanFactory());

        // 依赖来源三：容器內建 Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取 Environment 类型的 Bean：" + environment);
    }
}
