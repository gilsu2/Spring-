package dw.com.companyapp.service;


import dw.com.companyapp.dto.OrderRequestDTO;
import dw.com.companyapp.exception.ResourceNotFoundException;
import dw.com.companyapp.model.Order;
import dw.com.companyapp.model.OrderDetail;
import dw.com.companyapp.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

}