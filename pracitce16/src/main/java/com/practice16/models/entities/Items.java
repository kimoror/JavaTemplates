package com.practice16.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Entity
@Table(name = "items", schema = "java_templates")
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("creation_date")
//    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date creation_date;
    @JsonProperty("price")
    private double price;
    @ManyToOne
    @JsonProperty("order")
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Items() {};

    public Items(
            @JsonProperty("name") String name,
            @JsonProperty("creation_date") Date creation_date,
            @JsonProperty("price") double price) {
        this.name = name;
        this.creation_date = creation_date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
