package com.practice14.controllers;

import com.practice14.models.Orders;
import com.practice14.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    OrderRepo orderRepo;

    @Autowired
    public OrderController(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    };

    @GetMapping("/orders")
    public List<Orders> getOrders() {
        return orderRepo.getOrders();
    }

    @GetMapping("/addOrder")
    public String addOrder(@RequestParam String reqOrderDate) {
        Date orderDate = null;
        try {
            orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(reqOrderDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        orderRepo.createOrder(orderDate);
        return "ok";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam int index) {
        orderRepo.removeItem(index);
        return "Ok";
    }
}
