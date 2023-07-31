package com.newstar.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    // GET localhost:8080/
    @GetMapping("/")
    public String getMethod() {
        return "get method";
    }

    @PostMapping("/")
    public String postMethod() {
        return "post method";
    }

    @PatchMapping("/")
    public String patchMethod() {
        return "patch method";
    }

    @PutMapping("/")
    public String putMethod() {
        return "put method";
    }

    @DeleteMapping("/")
    public String deleteMethod() {
        return "delete method";
    }

}
