package com.lanceolata.code.snippets.spring.ioc.dependency.injection;

import com.lanceolata.code.snippets.common.domain.User;
import com.lanceolata.code.snippets.spring.ioc.dependency.injection.annotation.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

/**
 * Qualifier 注解依赖注入
 */
@Configuration
public class Demo_07_Qualifier {

    /** xmlUser2 -> primary = true */
    @Autowired
    private User user;

    /** 指定 Bean 名称或 ID */
    @Autowired
    @Qualifier("xmlUser1") //
    private User namedUser;

    /** xmlUser1 xmlUser2 xmlSupperUser1 */
    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    @Autowired
    @UserGroup
    private Collection<User> groupedUsers;

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(Demo_07_Qualifier.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找 QualifierAnnotationDependencyInjectionDemo Bean
        Demo_07_Qualifier demo = applicationContext.getBean(Demo_07_Qualifier.class);

        // 期待输出 xmlUser2
        System.out.println("demo.user = " + demo.user);
        // 期待输出 xmlUser1
        System.out.println("demo.namedUser = " + demo.namedUser);
        // 期待输出 xmlUser1 xmlUser2 xmlSupperUser1 user3 user4 user5 user6
        System.out.println("demo.allUsers = " + demo.allUsers);
        // 期待输出 user3 user4 user5 user6
        System.out.println("demo.qualifiedUsers = " + demo.qualifiedUsers);
        // 期待输出 user5 user6
        System.out.println("demo.groupedUsers = " + demo.groupedUsers);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }

    @Bean
    @Qualifier // 进行逻辑分组
    public User user3() {
        return createUser(3L);
    }

    @Bean
    @Qualifier // 进行逻辑分组
    public User user4() {
        return createUser(4L);

    }

    @Bean
    @UserGroup
    public User user5() {
        return createUser(5L);
    }

    @Bean
    @UserGroup
    public User user6() {
        return createUser(6L);
    }

    private static User createUser(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

}
