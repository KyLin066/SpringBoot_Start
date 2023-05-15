package com.example.SpringBoot_Start.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot_Start.domain.THello;
import com.example.SpringBoot_Start.service.THelloService;

import jakarta.annotation.Resource;

@RestController
public class THelloController {

    @Resource
    private THelloService tHelloService;
    
    @GetMapping("/")
    public String start() {
        return "Hello, SpringBoot";
    }

    @GetMapping("/springboot1/{name}")
    public String hello1(@PathVariable String name) {
        return "springboot1：" + name;
    }

    @GetMapping("/springboot2/{name}")
    public String hello2(@PathVariable String name) {
        return "springboot2：" + name;
    }

    @GetMapping("/thello/list")
    public List<THello> list() {
        return tHelloService.list();
    }

    @GetMapping("/springboot1/age/{name}")
    public String list(@PathVariable String name) {
        THello thello = tHelloService.findTHelloByName(name);
        if (thello == null) {
            return "不知道";
        } else {
            return "The age of " + name + " is : " + thello.getAge();
        }
    }

}
