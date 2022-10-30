package com.example.demo.dao;

import com.example.demo.pojo.Tuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tuser record);

    int insertSelective(Tuser record);

    Tuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tuser record);

    int updateByPrimaryKey(Tuser record);
    
    //查询用户名和密码是否存在
    int checkTuser(@Param("name")String name, @Param("pwd")String pwd);

    //查询用户名是否存在
    int checkName(@Param("name")String name);
    
}