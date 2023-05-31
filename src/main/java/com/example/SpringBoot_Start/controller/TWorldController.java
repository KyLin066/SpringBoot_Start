package com.example.SpringBoot_Start.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot_Start.domain.TWorld;
import com.example.SpringBoot_Start.mapper.TWorldMapper;

@RestController
@RequestMapping("/world")
public class TWorldController {

    @Autowired
    private TWorldMapper tWorldMapper;

    @GetMapping("/")
    public List<TWorld> getTWorldList() {
        return tWorldMapper.findAll();
    }

    @PostMapping("/")
    public String addTWorld(@RequestBody TWorld tWorld) {
        tWorldMapper.insert(tWorld);
        return "添加成功";
    }

    @PutMapping("/")
    public String updateTWorld(@RequestBody TWorld tWorld) {
        if (tWorldMapper.update(tWorld) == 1) {
            return "更新成功";
        } else {
            return "World不存在";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTWorld(@PathVariable Long id) {
        if (tWorldMapper.deleteById(id) == 1) {
            return "删除成功";
        } else {
            return "World不存在";
        }
    }

}
