package com.practice14.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Item {
    private String name;
    private Date creationDate;
    private double price;

    public Item() {
    }

    ;

    public Item(String name, Date creationDate, double price) {
        this.name = name;
        this.creationDate = creationDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
