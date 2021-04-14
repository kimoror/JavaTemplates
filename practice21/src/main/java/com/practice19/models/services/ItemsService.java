package com.practice19.models.services;

import com.practice19.aspect.Loggable;
import com.practice19.models.entities.Item;
import com.practice19.models.repositories.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.sql.Date;

@Slf4j
@Service
public class ItemsService {

    final
    ItemsRepository itemsRepository;

    final EmailService emailService;

    public ItemsService(ItemsRepository itemsRepository, EmailService emailService) {
        this.itemsRepository = itemsRepository;
        this.emailService = emailService;
    }

    @Loggable
    @Transactional
    public void save(String name, Date date, Double price){
        itemsRepository.save(new Item(name, date, price));
        emailService.sendMessageAttach(name);
    }

    @Loggable
    @Transactional
    public void save(Item item){
        itemsRepository.save(item);
        emailService.sendMessageAttach(item.getName());
        }

    @Loggable
    @Transactional
    public ArrayList<Item> getAll() {
        return new ArrayList<Item>(itemsRepository.findAll());
    }

    @Loggable
    @Transactional
    public void delete(int id){
        itemsRepository.deleteById(id);
    }
}
