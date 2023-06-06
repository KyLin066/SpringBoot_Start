package com.example.SpringBoot_Start.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot_Start.domain.TWorld;
import com.example.SpringBoot_Start.mapper.TWorldMapper;

@Service
public class TWorldService {

    @Autowired
    private TWorldMapper tWorldMapper;

    // 根据ID查询单个数据
    public TWorld getTWorldById(Long id) {
        return tWorldMapper.selectById(id);
    }

    //根据ID批量查询数据
    public List<TWorld> getTWorldByIds(List<Long> tWorldIds) {
        return tWorldMapper.selectByIds(tWorldIds);
    }

    // 查询数据数量
    public Long countTWorlds() {
        return tWorldMapper.count();
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
