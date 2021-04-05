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

import org.json.*;


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

    @RequestMapping(value = "/items/delete_item", method = RequestMethod.POST)
    @ResponseBody
    //TODO прописать в html, чтобы можно было вводить только цифры с помощбю регулярных выражений
    public void deleteItem(@RequestBody String delete_id_json) {
        JSONObject obj = new JSONObject(delete_id_json);
        String delete_id = obj.getString("delete_id");
        System.out.println(delete_id);
        itemsService.delete(Integer.parseInt(delete_id));
    }

    @RequestMapping(value = "/items/addItem",  method = RequestMethod.POST)
    @ResponseBody
    public void test(@RequestBody() Items items){
        itemsService.save(items);
    }
}
