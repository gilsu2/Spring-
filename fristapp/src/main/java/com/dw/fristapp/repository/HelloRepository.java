package com.dw.fristapp.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
    public String hello(){
        return "Hello word from repository.";
    }
}
