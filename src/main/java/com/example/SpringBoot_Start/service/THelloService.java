package com.example.SpringBoot_Start.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringBoot_Start.domain.THello;
import com.example.SpringBoot_Start.mapper.THelloMapper;

import jakarta.annotation.Resource;


@Service //Service层都需要添加@Service注解
public class THelloService {

    //使用@Resource将THelloMapper注入进来，也可以使用@Autowired
    //@Resource是JDK自带的，@Autowired是SpringBoot框架的
    @Resource
    private THelloMapper tHelloMapper;
    
    public List<THello> list () {
        return tHelloMapper.list();
    }

    public THello findTHelloByName(String name){
        return tHelloMapper.findTHelloByName(name);
    }

}
