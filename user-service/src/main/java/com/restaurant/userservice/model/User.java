package com.restaurant.userservice.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {

    private long id;
    private String name;
    private boolean active;

}
