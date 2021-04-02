package com.practice14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@Component
@ComponentScan
public class Practice14Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice14Application.class, args);
    }

}
