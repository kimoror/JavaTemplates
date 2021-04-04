package com.practice16.controllers;

import com.practice16.models.entities.Order;
import com.practice16.models.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrdersService ordersService;

    @GetMapping("/orders")
    @ResponseBody
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
