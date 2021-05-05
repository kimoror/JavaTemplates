package com.practice19.controllers;

import com.practice19.models.entities.Order;
import com.practice19.models.services.OrdersService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/orders/addOrder", method = RequestMethod.POST)
    @ResponseBody
    public void addOrder(@RequestBody() Order order){
        ordersService.addOrder(order);
    }

    @RequestMapping(value = "/orders/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public void deleteOrder(@RequestBody String delete_order_id_json){
        JSONObject obj = new JSONObject(delete_order_id_json);
        String delete_id = obj.getString("delete_id");
        ordersService.delete(Integer.parseInt(delete_id));
    }
}
