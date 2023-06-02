package com.example.SpringBoot_Start.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.example.SpringBoot_Start.service.TWorldService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/world")
@Tag(name = "World管理", description = "World管理相关接口")
public class TWorldController {

    @Autowired
    private TWorldMapper tWorldMapper;

    @Autowired
    private TWorldService tWorldService;

    // 查询全部数据
    @Operation(summary = "查询全部数据")
    @GetMapping("/")
    public List<TWorld> getTWorldList() {
        return tWorldMapper.findAll();
    }

    // 添加操作
    @Operation(summary = "添加单条数据")
    @PostMapping("/")
    public String addTWorld(@RequestBody TWorld tWorld) {
        tWorldMapper.insert(tWorld);
        return "添加成功";
    }

    // 修改操作
    @Operation(summary = "修改单条数据")
    @PutMapping("/")
    public String updateTWorld(@RequestBody TWorld tWorld) {
        if (tWorldMapper.update(tWorld) == 1) {
            return "更新成功";
        } else {
            return "World不存在";
        }
    }

    // 删除操作
    @Operation(summary = "删除单条数据")
    @DeleteMapping("/{id}")
    public String deleteTWorld(@PathVariable Long id) {
        if (tWorldMapper.deleteById(id) == 1) {
            return "删除成功";
        } else {
            return "World不存在";
        }
    }

    // 批量添加
    @Operation(summary = "批量添加数据")
    @PostMapping("/addBatch")
    public Map<String,List<Long>> addBatch(@RequestBody List<TWorld> tWorldList) {
        Map<String,List<Long>> result = new HashMap<>();
        List<Long> successIds = new ArrayList<>();
        List<Long> failedIds = new ArrayList<>();

        for(TWorld tWorld : tWorldList) {
            try {
                tWorldService.addTWorld(tWorld);
                successIds.add(tWorld.getId());
            } catch (Exception e) {
                failedIds.add(tWorld.getId());
            }
        }

        result.put("success", successIds);
        result.put("failed", failedIds);
        return result;
    }

}
