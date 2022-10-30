package com.example.demo.dao;

import com.example.demo.pojo.Tseller;
import com.example.demo.pojo.TsellerQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TsellerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Tseller record);

    int insertSelective(Tseller record);

    Tseller selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Tseller record);

    int updateByPrimaryKey(Tseller record);

    //分页相关：返回符合条件的某个区间的数据
    List<Tseller> selectPage(@Param("query")TsellerQuery query);

    int deleteIds(String[] ids);
}