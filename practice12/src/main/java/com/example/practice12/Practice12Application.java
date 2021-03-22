package com.example.practice12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
public class Practice12Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Practice12Application.class, args);

        Program program;
    }

}
