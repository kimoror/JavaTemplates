package com.practice19.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Component
@Entity
@Table(name = "items", schema = "java_templates")
@Setter
@Getter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("creation_date")
    private Date creation_date;
    @JsonProperty("price")
    private double price;
    //TODO Если хочешь , чтобы показывал заказ убери @JsonIgnore, вставь @JsonProperty("order") и  в Order убери List
//    @ManyToOne
////    @JsonProperty("order")
//    @JsonIgnore
//    private Order order;
    @JsonProperty("order_id")
    private int order_id;

    public Item() {};

    public Item(
            @JsonProperty("name") String name,
            @JsonProperty("creation_date") Date creation_date,
            @JsonProperty("price") double price) {
        this.name = name;
        this.creation_date = creation_date;
        this.price = price;
    }
}
