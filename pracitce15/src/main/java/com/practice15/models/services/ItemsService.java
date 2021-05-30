package com.practice15.models.services;

import com.practice15.models.entities.Items;
import com.practice15.models.repositories.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemsService{

    @Autowired
    ItemsRepository itemsRepository;

    public void save(String name, Date date, Double price){
        itemsRepository.save(new Items(name, date, price));
    }

    public ArrayList<Items> getAll() {
        return new ArrayList<Items>(itemsRepository.findAll());
    }

    public void delete(int id){
        itemsRepository.deleteById(id);
    }
}
