package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Order;
import com.dw.jdbcapp.model.Product;
import com.dw.jdbcapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/find-all-orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/api/orders/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/api/orders")
    public Order getOrderById_1(@RequestParam String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/api/orders/{id}/{num}")
    public Order getOrderCustomerById(@PathVariable String id,@PathVariable String num) {
        return orderService.getOrderCustomerById(id, num);
    }

    @GetMapping("/api/orderss")
    public Order getOrderCustomerById_1(@RequestParam String id,@RequestParam String num){
        return orderService.getOrderCustomerById(id,num);
    }

}






