package com.dw.secondapp.service;

import com.dw.secondapp.repository.ByeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ByeService {
    @Autowired
    ByeRepository byeRepository;
    public String bye(){
        return byeRepository.bye();
    }
}
