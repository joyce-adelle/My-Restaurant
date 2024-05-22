package com.restaurant.orderservice.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class AddOrderDTO {

    private List<String> items;

}

