package com.practice14.repo;


import com.practice14.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepo {

    List<Item> itemList;

    @Autowired
    public ItemRepo() {
        itemList = new ArrayList<>();
    }


    public void createItem(String name, Date date, Double price) {
        itemList.add(new Item(name, date, price));
    }

    public List<Item> getItems() {
        return itemList;
    }

    public void removeItem(Item item) {
        itemList.remove(item);
    }

    public void removeItem(int index) {
        itemList.remove(index);
    }

}
