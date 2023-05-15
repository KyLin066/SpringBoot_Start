package com.example.SpringBoot_Start.mapper;

import java.util.List;

import com.example.SpringBoot_Start.domain.THello;

public interface THelloMapper {

    public List<THello> list();

    public THello findTHelloByName(String name);
    
}
