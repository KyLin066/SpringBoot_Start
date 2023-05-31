package com.example.SpringBoot_Start.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.SpringBoot_Start.domain.TWorld;

public interface TWorldMapper {

    @Select("SELECT * FROM t_world")
    List<TWorld> findAll();

    @Insert("INSERT INTO t_world(uuid, active, worldName, worldAge, worldDesc, worldRadius, worldWeight, createTime) VALUES(uuid(), #{active}, #{worldName}, #{worldAge}, #{worldDesc}, #{worldRadius}, #{worldWeight}, now())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(TWorld tWorld);

    @Update("UPDATE t_world SET active=#{active}, worldName=#{worldName}, worldAge=#{worldAge}, worldDesc=#{worldDesc}, worldRadius=#{worldRadius}, worldWeight=#{worldWeight} WHERE id=#{id}")
    int update(TWorld tWorld);

    @Delete("DELETE FROM t_world WHERE id=#{id}")
    int deleteById(Long id);
    
}
