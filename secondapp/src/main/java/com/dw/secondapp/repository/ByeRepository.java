package com.dw.secondapp.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ByeRepository {
    public String bye(){
        return "Bye world from repository";
    }
}
