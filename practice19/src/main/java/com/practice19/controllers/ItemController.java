package com.practice19.controllers;

import com.practice19.models.dto.filterItemsDTO;
import com.practice19.models.entities.Item;
import com.practice19.models.services.ItemFilterService;
import com.practice19.models.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.json.*;


@Controller
public class ItemController {

    @Autowired
    ItemsService itemsService;
    @Autowired
    ItemFilterService itemFilterService;

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public String Items() {
        return "items";
    }

    @RequestMapping(value = "/items/getItems", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<Item> getItems() {
        return itemsService.getAll();
    }

    @RequestMapping(value = "/items/delete_item", method = RequestMethod.POST)
    @ResponseBody
    public void deleteItem(@RequestBody String delete_id_json) {
        JSONObject obj = new JSONObject(delete_id_json);
        String delete_id = obj.getString("delete_id");
        itemsService.delete(Integer.parseInt(delete_id));
    }

    @RequestMapping(value = "/items/addItem",  method = RequestMethod.POST)
    @ResponseBody
    public void addItem(@RequestBody() Item item){
//        items.getOrder().getId();
        itemsService.save(item);
    }

    @RequestMapping(value = "items/filter", method = RequestMethod.POST)
    @ResponseBody
//    @RequestParam String name, @RequestParam(name = "date") String reqDate, @RequestParam Double price, @RequestParam int order_id
    public List<Item> filter(@RequestBody() filterItemsDTO itemDTO){
//        Date reqDate = Date.valueOf(date);
        System.out.println(1);
        return itemFilterService.findItemsByNameAndCreation_dateAndPriceAndOrder_id(
                itemDTO.getName(),
                itemDTO.getCreation_date(),
                itemDTO.getPrice(),
                itemDTO.getOrder_id());
        //http://localhost:8080/items/filter?name=phone3&date=2020-04-09&price=4134&order_id=2
    }

}
