package com.dw.fristapp.service;

import com.dw.fristapp.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class HelloService {
    @Autowired
    HelloRepository helloRepository;
    public String hello(){
        return helloRepository.hello();
    }
}
