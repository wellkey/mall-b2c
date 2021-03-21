package com.pzh.portal.module.service;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/11 11:13
 * @Version 1.0
 */
public interface SecKillService {

    /**
     * 载入用于秒杀的商品库存
     * @param actId
     */
    void loadItemStock(long actId);

    /**
     * 执行lua脚本
     * @param luaFileName
     * @param keyList
     * @param args
     * @return
     */
    String executeScript(String luaFileName, List<String> keyList, Object... args);
}
