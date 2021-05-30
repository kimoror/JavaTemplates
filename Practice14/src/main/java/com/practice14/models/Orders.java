package com.practice14.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Orders {
    private Date orderDate;

    public Orders() {
    }

    ;

    public Orders(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
