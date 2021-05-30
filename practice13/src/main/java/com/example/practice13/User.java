package com.example.practice13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class User {

    @Value("${program.student.name}")
    public String name;

    @Value("${program.student.last_name}")
    public String last_name;

    @Value("${program.student.group}")
    public String group;

    @PostConstruct
    public void init() {
        System.out.println(name);
        System.out.println(last_name);
        System.out.println(group);
    }
}
