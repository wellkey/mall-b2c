package com.pzh.mall.module.service;

import com.pzh.mall.module.domain.Attribute;
import com.pzh.mall.module.domain.AttributeValue;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 13:11
 * @Version 1.0
 */
public interface AttributeService {

    List<Attribute> list(String name);

    Attribute read(long id);

    void add(Attribute brand);

    void edit(Attribute brand);

    void remove(long id);

    String getCategoryStr(Long categoryId);

    AttributeValue saveOrUpdateValues(AttributeValue value);

    List<AttributeValue> readValues(long attributeId);
}
