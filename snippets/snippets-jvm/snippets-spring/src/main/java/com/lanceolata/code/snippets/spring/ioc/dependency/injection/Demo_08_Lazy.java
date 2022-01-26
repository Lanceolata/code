package com.lanceolata.code.snippets.spring.ioc.dependency.injection;

import com.lanceolata.code.snippets.common.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * ObjectProvider 实现延迟依赖注入
 */
@Configuration
public class Demo_08_Lazy {
    /** 实时注入 */
    @Autowired
    @Qualifier("xmlUser1")
    private User user;

    /** 延迟注入 */
    @Autowired
    private ObjectProvider<User> userObjectProvider;

    @Autowired
    private ObjectFactory<Set<User>> usersObjectFactory;

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class（配置类） -> Spring Bean
        applicationContext.register(Demo_08_Lazy.class);

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);

        // 加载 XML 资源，解析并且生成 BeanDefinition
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        beanDefinitionReader.loadBeanDefinitions(xmlResourcePath);

        // 启动 Spring 应用上下文
        applicationContext.refresh();

        // 依赖查找
        Demo_08_Lazy demo = applicationContext.getBean(Demo_08_Lazy.class);

        // 期待输出 xmlUser2 Bean
        System.out.println("demo.user = " + demo.user);
        // 期待输出 xmlUser2 Bean
        System.out.println("demo.userObjectProvider = " + demo.userObjectProvider.getObject());
        // 期待输出 xmlUser1 xmlUser2 xmlSupperUser1 Beans
        System.out.println("demo.usersObjectFactory = " + demo.usersObjectFactory.getObject());

        demo.userObjectProvider.forEach(System.out::println);

        // 显示地关闭 Spring 应用上下文
        applicationContext.close();
    }
}
