package com.example.SpringBoot_Start.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.SpringBoot_Start.domain.TWorld;

public interface TWorldMapper {

    // 查询全部数据
    @Select("SELECT * FROM t_world")
    List<TWorld> findAll();

    // 根据ID查询单条数据
    @Select("SELECT * FROM t_world WHERE id = #{id}")
    TWorld selectById(Long id);

    // 新增数据
    @Insert("INSERT INTO t_world(uuid, active, worldName, worldAge, worldDesc, worldRadius, worldWeight, createTime) VALUES(uuid(), #{active}, #{worldName}, #{worldAge}, #{worldDesc}, #{worldRadius}, #{worldWeight}, now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TWorld tWorld);

    // 修改数据
    @Update("UPDATE t_world SET active=#{active}, worldName=#{worldName}, worldAge=#{worldAge}, worldDesc=#{worldDesc}, worldRadius=#{worldRadius}, worldWeight=#{worldWeight} WHERE id=#{id}")
    int update(TWorld tWorld);

    // 根据ID删除数据
    @Delete("DELETE FROM t_world WHERE id=#{id}")
    int deleteById(Long id);
    
    // 批量添加
    // @Insert("INSERT INTO t_world(uuid, active, worldName, worldAge, worldDesc, worldRadius, worldWeight, createTime) VALUES(uuid(), #{active}, #{worldName}, #{worldAge}, #{worldDesc}, #{worldRadius}, #{worldWeight}, now())")
    // @Options(useGeneratedKeys = true, keyProperty = "id")
    // int batchInsert(List<TWorld> tWorldList);
}
