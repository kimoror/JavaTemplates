package com.practice15.models.services;

import com.practice15.models.entities.Order;
import com.practice15.models.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public void save(Date date){
        ordersRepository.save(new Order(date));
    }

    public ArrayList<Order> getAll() {
        return new ArrayList<Order>(ordersRepository.findAll());
    }

    public void delete(int id){
        ordersRepository.deleteById(id);
    }
}
