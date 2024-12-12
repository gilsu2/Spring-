package com.dw.secondapp.controller;

import com.dw.secondapp.service.ByeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {
    @Autowired
    ByeService byeService;
    @GetMapping("/bye")
    public String bye(){
        return byeService.bye();
    }
}






