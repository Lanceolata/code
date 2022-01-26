package com.lanceolata.code.snippets.spring.ioc.dependency.injection;

import com.lanceolata.code.snippets.common.domain.repository.UserNameRepository;
import com.lanceolata.code.snippets.common.domain.repository.UserTypeRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 */
public class Demo_01 {
    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 按名称注入-实时
        injectByName(applicationContext);
        injectByType(applicationContext);
    }

    private static void injectByName(ApplicationContext applicationContext) {
        UserNameRepository userNameRepository = applicationContext.getBean(UserNameRepository.class);
        System.out.println(userNameRepository.getUsers());
    }

    private static void injectByType(ApplicationContext applicationContext) {
        UserTypeRepository userTypeRepository = applicationContext.getBean(UserTypeRepository.class);
        System.out.println(userTypeRepository.getUsers());
    }
}
