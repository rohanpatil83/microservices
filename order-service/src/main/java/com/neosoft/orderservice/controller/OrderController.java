package com.neosoft.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/welcome")
    public String welcome() {
        return "WELCOME TO ORDER SERVICE";
    }



}
