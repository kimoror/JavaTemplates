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

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(){return "orders";}

    @GetMapping("/orders/getOrders")
    @ResponseBody
    public List<Order> getOrders() {
        return ordersService.getAll();
    }

//    @GetMapping("orders/addOrder")
//    public String addOrder(@RequestParam String reqOrderDate) {
//        Date orderDate = null;
//        try {
//            orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(reqOrderDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        ordersService.save(orderDate);
//        return "ok";
//    }

//    @RequestMapping(value = "/orders/addOrder", method = RequestMethod.POST)
//    @ResponseBody
//    public void addOrder(@RequestBody() Order order){
//        ordersService.save;
//    }

    @GetMapping("orders/deleteOrder")
    public String deleteOrder(@RequestParam int index) {
        ordersService.delete(index);
        return "Ok";
    }
}
