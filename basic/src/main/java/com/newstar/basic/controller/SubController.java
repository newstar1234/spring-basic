package com.newstar.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sub")
public class SubController {
    
    // GET localhost:8080/sub
    @GetMapping("/")
    public String getMethod() {
        return "sub get method";
    }

}
