package com.newstar.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newstar.basic.service.MainService;

import lombok.RequiredArgsConstructor;

@RestController
// description : http://localhost:8080/sub //
@RequestMapping("/sub")
@RequiredArgsConstructor
public class SubController {
    
    public final MainService mainService;

    @GetMapping("/")
    public String getMethod() {
        return "sub get method";
    }

    @GetMapping("/repository-get")
    public String getRepository() {
        return mainService.getRepository();
    }

}
