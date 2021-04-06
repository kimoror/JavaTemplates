package com.practice16.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Component
@Entity
@Table(schema = "java_templates", name = "orders")
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("order_date")
    private Date order_date;
    @OneToMany(mappedBy = "order_id", fetch = FetchType.LAZY)
    private List<Items> items;

    public Order() {};

    public Order(@JsonProperty Date order_date) {
        this.order_date = order_date;
    }
}
