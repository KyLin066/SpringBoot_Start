package com.example.SpringBoot_Start.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot_Start.domain.TWorld;
import com.example.SpringBoot_Start.mapper.TWorldMapper;

@Service
public class TWorldService {

    @Autowired
    private TWorldMapper tWorldMapper;

    // 根据ID查询数据
    public TWorld getTWorldById(Long id) {
        return tWorldMapper.selectById(id);
    }

    // 添加数据
    public void addTWorld(TWorld tWorld) {
        tWorldMapper.insert(tWorld);
    }

    // 删除数据
    public void deleteTWorld(Long tWorldId) {
        tWorldMapper.deleteById(tWorldId);
    }

    // public void addBatch(List<TWorld> tWorldList) {
    // for (TWorld tWorld : tWorldList){
    // tWorldMapper.insert(tWorld);
    // }
    // }

}
