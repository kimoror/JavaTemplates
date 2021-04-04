package com.practice16.models.services;

import com.practice16.models.entities.Items;
import com.practice16.models.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ItemsService{

    @Autowired
    ItemsRepository itemsRepository;

    public void save(String name, Date date, Double price){
        itemsRepository.save(new Items(name, date, price));
    }
        public void save(Items item){
        itemsRepository.save(item);
    }

    public ArrayList<Items> getAll() {
        return new ArrayList<Items>(itemsRepository.findAll());
    }

    public void delete(int id){
        itemsRepository.deleteById(id);
    }
}
