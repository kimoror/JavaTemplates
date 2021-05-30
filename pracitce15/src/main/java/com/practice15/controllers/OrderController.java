package com.practice15.controllers;

import com.practice15.models.entities.Order;
import com.practice15.models.services.OrdersService;
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

    @Autowired
    OrdersService ordersService;

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return ordersService.getAll();
    }

    @GetMapping("/addOrder")
    public String addOrder(@RequestParam String reqOrderDate) {
        Date orderDate = null;
        try {
            orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(reqOrderDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ordersService.save(orderDate);
        return "ok";
    }

    @GetMapping("/deleteOrder")
    public String deleteOrder(@RequestParam int index) {
        ordersService.delete(index);
        return "Ok";
    }
}
