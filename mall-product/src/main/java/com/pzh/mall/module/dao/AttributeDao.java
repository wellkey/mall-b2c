package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.AttributeKey;
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

    List<AttributeKey> list(@Param("name") String name);

    AttributeKey read(long id);

    void add(@Param("name")String name, @Param("categoryId")long categoryId);

    void edit(@Param("id")long id, @Param("name")String name, @Param("categoryId")long categoryId);

    void remove(long id);

    void removeValues(@Param("attributeId") long attributeId);

    void saveOrUpdateValues(@Param("attributeId") long attributeId, @Param("attributeValue") String attributeValue);

    List<AttributeValue> readValues(@Param("attributeId") long attributeId);
}
