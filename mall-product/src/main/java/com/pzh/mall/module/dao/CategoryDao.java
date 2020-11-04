package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/10/27 10:59
 * @Version 1.0
 */
@Mapper
public interface CategoryDao {

    List<Category> list();

    Category read(long id);

    void add(Category category);

    void edit(Category category);

    void remove(long id);
}
