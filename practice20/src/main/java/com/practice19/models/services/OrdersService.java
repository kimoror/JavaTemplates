package com.practice19.models.services;

import com.practice19.aspect.Loggable;
import com.practice19.models.entities.Order;
import com.practice19.models.repositories.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;

@Slf4j
@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    @Loggable
    public void addOrder(Date date){
        ordersRepository.save(new Order(date));
    }

    @Loggable
    public void addOrder(Order order){
        ordersRepository.save(order);
    }

    @Loggable
    public ArrayList<Order> getAll() {
        return new ArrayList<Order>(ordersRepository.findAll());
    }

    @Loggable
    public void delete(int id){
        ordersRepository.deleteById(id);
    }
}
