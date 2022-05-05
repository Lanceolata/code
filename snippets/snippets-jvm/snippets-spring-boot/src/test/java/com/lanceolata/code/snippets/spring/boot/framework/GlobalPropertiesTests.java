package com.lanceolata.code.snippets.spring.boot.framework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "mount.cluster=test")
public class GlobalPropertiesTests {
    @Autowired
    private GlobalProperties globalProperties;

    @Test
    public void testJonName() {
        System.out.println(globalProperties.getJobName());
    }

    @Test
    public void testMountCluster() {
        System.out.println(globalProperties.getMountCluter());
    }
}
