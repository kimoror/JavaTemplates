package com.practice19.models.repositories;

import com.practice19.models.entities.Item;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ItemFilterRepository{
    List<Item> findItemsByNameAndCreation_dateAndPriceAndOrder_id(
            String name, Date creation_date, double price, int order_id);
}
