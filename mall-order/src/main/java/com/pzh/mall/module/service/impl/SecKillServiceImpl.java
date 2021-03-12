package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.SecKillDao;
import com.pzh.mall.module.domain.Commodity;
import com.pzh.mall.module.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/11 15:36
 * @Version 1.0
 */
@Service
public class SecKillServiceImpl implements SecKillService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecKillServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SecKillDao secKillDao;

    @Override
    public void loadItemStock(long actId) {
        Map<String, String> map = new HashMap<>();

        List<Commodity> commodityList = secKillDao.list(actId);
        if (commodityList != null && commodityList.size() > 0) {
            for (Commodity commodity : commodityList) {
                map.put(commodity.getItemId() + "", commodity.getStock() + "");
            }

            // 加载到redis
            redisTemplate.opsForHash().putAll("sec_sku_stock", map);
        }
    }

    @Override
    public String executeScript(String luaFileName, List<String> keyList, Object... args) {
        DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/" + luaFileName)));
        redisScript.setResultType(String.class);
        String result = "";
        try {
            result = String.valueOf(redisTemplate.execute(redisScript, keyList, args));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
