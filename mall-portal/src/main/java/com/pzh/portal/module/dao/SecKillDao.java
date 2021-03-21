package com.pzh.portal.module.dao;

import com.pzh.portal.module.domain.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/11 11:11
 * @Version 1.0
 */
@Mapper
public interface SecKillDao {

    /**
     * 列出所有用于秒杀的商品
     * @param actId
     * @return
     */
    List<Commodity> list(long actId);
}
