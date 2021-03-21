package com.pzh.manage.module.dao;

import com.pzh.manage.module.domain.Category;
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
public interface CategoryDao {

    List<Category> list(@Param("level") int level, @Param("parId") long parId, @Param("name") String name);

    Category read(long id);

    void add(String name, long parId, int level, String unit);

    void edit(long id, String name, long parId, int level, String unit);

    void remove(long id);
}
