package com.restaurant.orderservice.service;

import com.restaurant.orderservice.models.Order;
import com.restaurant.orderservice.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderService {

    private final List<Order> orders;

    public OrderService() {

        this.orders = new ArrayList<>(Arrays.asList(Order.builder()
                        .id(10L)
                        .items(Arrays.asList("burger", "coffee"))
                        .status(Status.PENDING)
                        .build(),
                Order.builder()
                        .id(11L)
                        .items(Arrays.asList("coffee", "meat pie", "apple"))
                        .status(Status.COMPLETED)
                        .build(),
                Order.builder()
                        .id(12L)
                        .items(Arrays.asList("egg roll", "tea"))
                        .status(Status.INPROGRESS)
                        .build()));

    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getOrder(long id) {

        Optional<Order> orderOp = orders.stream().filter(order -> order.getId() == id).findFirst();
        return orderOp.orElse(null);

    }

    public Order updateOrder(Order order) {

        Optional<Order> orderOp = orders.stream()
                .filter(orderF -> orderF.getId() == order.getId())
                .map(order1 -> {
                    order1.setItems(order.getItems());
                    order1.setStatus(order.getStatus());
                    return order1;
                })
                .findFirst();
        return orderOp.orElse(null);

    }

    public Order addOrder(List<String> items) {

        Order newOrder = Order.builder()
                .id(orders.size() + 1L)
                .items(items)
                .status(Status.PENDING)
                .build();
        orders.add(newOrder);

        return newOrder;

    }

    public boolean cancelOrder(long id) {

        Optional<Order> orderOp = orders.stream()
                .filter(orderF -> orderF.getId() == id)
                .map(order1 -> {
                    order1.setStatus(Status.CANCELLED);
                    return order1;
                })
                .findFirst();

        return orderOp.isPresent();

    }

}
