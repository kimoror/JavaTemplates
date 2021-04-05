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

    @RequestMapping(value = "/items/delete_item", method = RequestMethod.POST)
    @ResponseBody
    public void deleteItem(@RequestBody String delete_id_json) {
        JSONObject obj = new JSONObject(delete_id_json);
        String delete_id = obj.getString("delete_id");
        System.out.println(delete_id);
        itemsService.delete(Integer.parseInt(delete_id));
    }

    @RequestMapping(value = "/items/addItem",  method = RequestMethod.POST)
    @ResponseBody
    public void addItem(@RequestBody() Items items){
        itemsService.save(items);
    }
}
