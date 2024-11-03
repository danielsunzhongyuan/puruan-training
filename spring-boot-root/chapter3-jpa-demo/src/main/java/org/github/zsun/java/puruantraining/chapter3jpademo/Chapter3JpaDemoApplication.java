package org.github.zsun.java.puruantraining.chapter3jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Chapter3JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chapter3JpaDemoApplication.class, args);
        ClassPathXmlApplicationContext sdfd = new ClassPathXmlApplicationContext("sdfd");
        sdfd.getBean("df");
    }

}
