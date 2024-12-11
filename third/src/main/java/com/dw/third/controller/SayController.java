package com.dw.third.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayController {
    @GetMapping("/love")
    public String love() {
            return "I LOVE YOU";
        }
    }