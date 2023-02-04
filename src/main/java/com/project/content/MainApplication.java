package com.project.content;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        /** SpringApplication is used to bootstrap spring application from main method
         * it creates an ApplicationContext instance
         *
         * */
        SpringApplication.run(MainApplication.class, args);
    }

    /** below we are using CommandLineRunner interface to retrie all beans created by me or provided by spring boot, sorting and printing them
         **
         reference: https://github.com/xp-vit/gs-spring-boot/blob/master/initial/src/main/java/hello/Application.java
         **
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String[] beans = ctx.getBeanDefinitionNames();
            Arrays.sort(beans);
            for(String bean : beans) {
                System.out.println(bean);
            }
        };
    }
}