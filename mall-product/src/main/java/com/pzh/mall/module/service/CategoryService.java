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

    List<Category> list();

    Category read(long id);

    void add(Category category);

    void edit(Category category);

    void remove(long id);
}
