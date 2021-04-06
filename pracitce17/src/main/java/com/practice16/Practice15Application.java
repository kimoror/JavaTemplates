package com.practice16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.practice16.models.services.OrdersService;

@SpringBootApplication
public class Practice15Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice15Application.class, args);
    }

}
