package com.restaurant.orderservice.models;

import lombok.Data;

import java.util.List;

@Data
public class AddOrderDTO {

    private List<String> items;

}

