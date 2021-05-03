package com.practice19.models.services;

import com.practice19.aspect.Loggable;
import com.practice19.models.entities.Order;
import com.practice19.models.repositories.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;

@Slf4j
@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    @Loggable
    @Transactional
    public void addOrder(Date date){
        ordersRepository.save(new Order(date));
    }

    @Loggable
    @Transactional
    public void addOrder(Order order){
        ordersRepository.save(order);
    }

    @Loggable
    @Transactional
    public ArrayList<Order> getAll() {
        return new ArrayList<Order>(ordersRepository.findAll());
    }

    @Loggable
    @Transactional
    public void delete(int id){
        ordersRepository.deleteById(id);
    }
}
