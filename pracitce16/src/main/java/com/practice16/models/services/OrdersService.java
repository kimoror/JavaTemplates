package com.practice16.models.services;

import com.practice16.models.entities.Order;
import com.practice16.models.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public void addOrder(Date date){
        ordersRepository.save(new Order(date));
    }

    public void addOrder(Order order){
        ordersRepository.save(order);
    }

    public ArrayList<Order> getAll() {
        return new ArrayList<Order>(ordersRepository.findAll());
    }

    public void delete(int id){
        ordersRepository.deleteById(id);
    }
}
