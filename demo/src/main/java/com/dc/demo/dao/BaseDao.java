package com.dc.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<T,E,K> extends Serializable{

    int countByCriteria(E criteria);

    int deleteByCriteria(E criteria);

    int deleteByPrimaryKey(K key);

    int insert(T entity);

    int insertSelective(T entity);

    List<T> selectByCriteria(E criteria);

    T selectByPrimaryKey(K key);

    int updateByCriteriaSelective(@Param("record") T entity, @Param("example") E criteria);

    int updateByPrimaryKeySelective(T entity);

}