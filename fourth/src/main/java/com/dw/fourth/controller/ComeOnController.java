package com.dw.fourth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComeOnController {
    @GetMapping("/come")
    public String come() {
        return "Come on World";

    }
}
