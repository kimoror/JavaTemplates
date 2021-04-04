package com.practice16.controllers;

import com.practice16.models.entities.Items;
import com.practice16.models.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class ItemController {

    @Autowired
    ItemsService itemsService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String Items() {
        return "items";
    }

    @RequestMapping(value = "/items/getItems", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Items> getItems() {
        return itemsService.getAll();
    }

    //example of request http://localhost:8080/addItem?name=kolya&date=20/06/2020&price=3000
//    @GetMapping(value = "/addItem")
//    @ResponseBody
//    public String addItem(@RequestParam String name, @RequestParam(name = "date") String reqDate, @RequestParam Double price) {
//        Date date = null;
//        try {
//            date = new SimpleDateFormat("dd/MM/yyyy").parse(reqDate);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        itemsService.save(name, date, price);
//        return "ok";
//    }

    @RequestMapping(value = "/addItem",  method = RequestMethod.POST)
    @ResponseBody
    public void addItem(@RequestBody() String item) {
//        itemsService.save(item);
        System.out.println(item);
//        return "ok";
    }

    @GetMapping(value = "/delete_item")
    public String deleteItem(@RequestParam int index) {
        itemsService.delete(index);
        return "ok";
    }

    @RequestMapping(value = "/items/addItem",  method = RequestMethod.POST)
    @ResponseBody
    public void test(@RequestBody() Items items){
        System.out.println(items.toString());
        itemsService.save(items);
    }
}
