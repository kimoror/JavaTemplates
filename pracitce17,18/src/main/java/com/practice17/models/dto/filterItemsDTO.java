package com.practice17.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
