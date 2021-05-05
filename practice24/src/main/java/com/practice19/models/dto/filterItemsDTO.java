package com.practice19.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
public class filterItemsDTO {
    private String name;
    private Date creation_date;
    private double price;
    private int order_id;
}
