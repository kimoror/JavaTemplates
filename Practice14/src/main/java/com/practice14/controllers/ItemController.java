package com.practice14.controllers;

import com.practice14.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
public class ItemController {

    ItemRepo itemRepo;

    @Autowired
    public ItemController(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping(value = "/items", produces = "application/json")
    @ResponseBody
    public List getItems() {
        return itemRepo.getItems();
    }

    //example of request http://localhost:8080/add_item?name=kolya&date=20/06/2020&price=3000
    @GetMapping(value = "/addItem")
    @ResponseBody
    public String addItem(@RequestParam String name, @RequestParam(name = "date") String reqDate, @RequestParam Double price) {
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(reqDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        itemRepo.createItem(name, date, price);
        return "ok";
    }

    @GetMapping(value = "/delete_item")
    public String deleteItem(@RequestParam int index) {
        itemRepo.removeItem(index);
        return "ok";
    }
}
