package com.practice17.models.services;

import com.practice17.models.entities.Order;
import com.practice17.models.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

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
