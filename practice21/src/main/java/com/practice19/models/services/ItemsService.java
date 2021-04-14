package com.practice19.models.services;

import com.practice19.aspect.Loggable;
import com.practice19.models.entities.Item;
import com.practice19.models.repositories.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.sql.Date;

@Slf4j
@Service
public class ItemsService {

    @Autowired
    ItemsRepository itemsRepository;

    @Loggable
    public void save(String name, Date date, Double price){
        itemsRepository.save(new Item(name, date, price));
    }

    @Loggable
    public void save(Item item){
        itemsRepository.save(item);
        }

    @Loggable
    public ArrayList<Item> getAll() {
        return new ArrayList<Item>(itemsRepository.findAll());
    }

    @Loggable
    public void delete(int id){
        itemsRepository.deleteById(id);
    }
}
