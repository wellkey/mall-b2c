package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.Attribute;
import com.pzh.mall.module.domain.AttributeValue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 10:59
 * @Version 1.0
 */
@Mapper
public interface AttributeDao {

    List<Attribute> list(@Param("name") String name);

    Attribute read(long id);

    void add(Attribute brand);

    void edit(Attribute brand);

    void remove(long id);

    AttributeValue saveOrUpdateValues(AttributeValue value);

    List<AttributeValue> readValues(@Param("attributeId") long attributeId);
}
