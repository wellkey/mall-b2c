package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.Brand;
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
public interface BrandDao {

    List<Brand> list(@Param("name") String name);

    Brand read(long id);

    void add(Brand brand);

    void edit(Brand brand);

    void remove(long id);
}
