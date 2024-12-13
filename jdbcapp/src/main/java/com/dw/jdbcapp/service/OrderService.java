package com.dw.jdbcapp.service;

import com.dw.jdbcapp.model.Order;
import com.dw.jdbcapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order>getAllOrders(){
        return orderRepository.getAllOrders();
    }
    public Order getOrderById(String id){
        return orderRepository.getOrderById(id);
    }
    public Order getOrderCustomerById (String id,String num){
        return orderRepository.getOrderCustomerById(id, num);
    }
}
