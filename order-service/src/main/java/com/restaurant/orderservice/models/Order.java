package com.restaurant.orderservice.models;

import com.restaurant.orderservice.utils.Status;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Order {

    private long id;
    private List<String> items;
    private Status status;

}
