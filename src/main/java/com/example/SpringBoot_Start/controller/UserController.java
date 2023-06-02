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

import com.example.SpringBoot_Start.domain.User;
import com.example.SpringBoot_Start.mapper.UserMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "用户管理", description = "用户管理相关接口")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 查询全部用户
    @Operation(summary = "查询全部用户")
    @GetMapping("/")
    public List<User> getUserList() {
        return userMapper.findAll();
    }

    // 添加操作
    @Operation(summary = "添加单个用户")
    @PostMapping("/")
    public String addUser(@RequestBody User user) {
        userMapper.insert(user);
        return "添加成功";
    }

    // 修改操作
    @Operation(summary = "修改单个用户")
    @PutMapping("/")
    public String updateUser(@RequestBody User user) {
        if (userMapper.update(user) == 1) {
            return "更新成功";
        } else {
            return "用户不存在";
        }
    }

    // 删除操作
    @Operation(summary = "删除单个用户")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (userMapper.deleteById(id) == 1) {
            return "删除成功";
        } else {
            return "用户不存在";
        }
    }
}
