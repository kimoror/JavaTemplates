package com.practice19.services;

import com.practice19.models.entities.Item;
import com.practice19.models.entities.Order;
import com.practice19.models.repositories.OrdersRepository;
import com.practice19.models.services.EmailService;
import com.practice19.models.services.OrdersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrdersRepository ordersRepository;

    @Captor
    private ArgumentCaptor<Order> orderArgumentCaptor;

    @Captor
    private ArgumentCaptor<Integer> orderIdArgumentCaptor;

    @Test
    void addAll(){
        Item item = new Item();
        item.setCreation_date(Date.valueOf("2020-05-04"));
        item.setPrice(4442);
        item.setName("TestItem");
        item.setOrder_id(1);

        Item item2 = new Item();
        item2.setCreation_date(Date.valueOf("2020-03-07"));
        item2.setPrice(5553);
        item2.setName("TestItemTwo");
        item2.setOrder_id(1);

        Item item3 = new Item();
        item.setCreation_date(Date.valueOf("2010-05-23"));
        item.setPrice(3332);
        item.setName("TestItemThree");
        item.setOrder_id(1);

        Item item4 = new Item();
        item2.setCreation_date(Date.valueOf("2015-11-16"));
        item2.setPrice(6665);
        item2.setName("TestItemFourth");
        item2.setOrder_id(1);

        Order order = new Order();
        order.setOrder_date(Date.valueOf("2018-09-23"));
        order.setItems(List.of(item, item2));

        Order order2 = new Order();
        order2.setOrder_date(Date.valueOf("2021-01-12"));
        order2.setItems(List.of(item3, item4));

        Mockito.when(ordersRepository.findAll()).thenReturn(List.of(order, order2));
        OrdersService ordersService = new OrdersService(ordersRepository);
        assertEquals(2, ordersService.getAll().size());
        assertEquals("2021-01-12", ordersService.getAll().get(1).getOrder_date().toString());
    }

    @Test
    void addOrder(){
        Item item = new Item();
        item.setCreation_date(Date.valueOf("2020-05-04"));
        item.setPrice(4442);
        item.setName("TestItem");
        item.setOrder_id(1);

        Order order = new Order();
        order.setOrder_date(Date.valueOf("2018-09-23"));
        order.setItems(List.of(item));

        OrdersService ordersService = new OrdersService(ordersRepository);
        ordersService.addOrder(order);
        Mockito.verify(ordersRepository).save(orderArgumentCaptor.capture());
        Order captor = orderArgumentCaptor.getValue();
        assertEquals("2018-09-23", captor.getOrder_date().toString());
    }

    @Test
    void delete(){
        Item item = new Item();
        item.setCreation_date(Date.valueOf("2020-05-04"));
        item.setPrice(4442);
        item.setName("TestItem");
        item.setOrder_id(1);

        Order order = new Order();
        order.setOrder_date(Date.valueOf("2018-09-23"));
        order.setItems(List.of(item));

        OrdersService ordersService = new OrdersService(ordersRepository);
        ordersService.addOrder(order);

        ordersService.delete(0);
        Mockito.verify(ordersRepository).deleteById(orderIdArgumentCaptor.capture());
        int captured = orderIdArgumentCaptor.getValue();
        assertEquals(0, captured);
    }
}
