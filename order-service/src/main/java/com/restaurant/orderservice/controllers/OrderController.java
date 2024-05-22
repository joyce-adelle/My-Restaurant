package com.restaurant.orderservice.controllers;

import com.restaurant.orderservice.models.AddOrderDTO;
import com.restaurant.orderservice.models.Order;
import com.restaurant.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public Order addOrder(@Validated @RequestBody AddOrderDTO order) {
        return orderService.addOrder(order.getItems());
    }

    @PatchMapping("/{id}")
    public Order updateOrder(@Validated @RequestBody Order order) {
        return orderService.updateOrder(order);
    }

    @PatchMapping("/cancel/{id}")
    public boolean cancelOrder(@PathVariable long id) {
        return orderService.cancelOrder(id);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable long id) {
        return orderService.getOrder(id);
    }

}
