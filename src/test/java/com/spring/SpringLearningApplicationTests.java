package com.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class SpringLearningApplicationTests {

    @Test
    void contextLoads() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"bean.xml"});
    }

}
