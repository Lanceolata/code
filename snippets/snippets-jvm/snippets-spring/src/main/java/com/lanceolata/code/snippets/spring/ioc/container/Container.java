package com.lanceolata.code.snippets.spring.ioc.container;

import com.lanceolata.code.snippets.common.domain.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Container {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-source-context.xml");

        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);

        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
        // ConfigurableApplicationContext#getBeanFactory()
        // false
        System.out.println(userRepository.getBeanFactory() == applicationContext);
    }
}
