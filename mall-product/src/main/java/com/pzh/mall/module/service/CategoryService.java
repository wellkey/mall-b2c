package com.pzh.mall.module.service;

import com.pzh.mall.module.domain.Category;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 13:11
 * @Version 1.0
 */
public interface CategoryService {

    List<Category> list(int level, long parId, String name);

    Category read(long id);

    void add(String name, long parId, int level, String unit);

    void edit(long id, String name, long parId, int level, String unit);

    void remove(long id);
}
