package com.pzh.mall.module.service;

import com.pzh.mall.module.domain.AttributeKey;
import com.pzh.mall.module.domain.AttributeValue;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 13:11
 * @Version 1.0
 */
public interface AttributeService {

    List<AttributeKey> list(String name);

    AttributeKey read(long id);

    void add(String name, long categoryId);

    void edit(long id, String name, long categoryId);

    void remove(long id);

    String getCategoryStr(Long categoryId);

    void saveOrUpdateValues(long attributeId, String values);

    List<AttributeValue> readValues(long attributeId);
}
