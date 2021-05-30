package com.practice14.repo;

import com.practice14.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class OrderRepo {

    List<Orders> ordersList;

    @Autowired
    public OrderRepo() {
        ordersList = new ArrayList<>();
    }

    public void createOrder(Date date) {
        ordersList.add(new Orders(date));
    }

    public List<Orders> getOrders() {
        return ordersList;
    }

    public void removeItem(Orders orders) {
        ordersList.remove(orders);
    }

    public void removeItem(int index) {
        ordersList.remove(index);
    }
}
