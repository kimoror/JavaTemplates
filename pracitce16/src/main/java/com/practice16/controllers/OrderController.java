package com.practice16.controllers;

import com.practice16.models.entities.Order;
import com.practice16.models.services.OrdersService;
import org.json.JSONObject;
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

    @RequestMapping(value = "/orders/addOrder", method = RequestMethod.POST)
    @ResponseBody
    public void addOrder(@RequestBody() Order order){
        ordersService.addOrder(order);
    }

//    @GetMapping("orders/deleteOrder")
//    public String deleteOrder(@RequestParam int index) {
//        ordersService.delete(index);
//        return "Ok";
//    }
    @RequestMapping(value = "orders/deleteOrder", method = RequestMethod.POST)
    @ResponseBody
    public void deleteOrder(@RequestBody String delete_order_id_json){
        JSONObject obj = new JSONObject(delete_order_id_json);
        String delete_id = obj.getString("delete_id");
        ordersService.delete(Integer.parseInt(delete_id));
    }
}
