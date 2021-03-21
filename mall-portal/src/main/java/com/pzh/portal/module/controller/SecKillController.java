package com.pzh.portal.module.controller;

import com.google.common.collect.Lists;
import com.pzh.portal.module.service.SecKillService;
import com.pzh.portal.module.thread.SecKillTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/16 20:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/secKill")
public class SecKillController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecKillController.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SecKillService secKillService;

    @RequestMapping("/start/{skuId}")
    @ResponseBody
    public String start(@PathVariable long skuId) {
        // 商品库存key
        String secSkuStock = "sec_sku_stock";
        // 秒杀到的用户key
        String secSuccessUser = "sec_success_user";

        //门闩一：以便所有线程同时开始运行
        CountDownLatch switchLatch = new CountDownLatch(1);
        //门闩二：以便所有线程都能运行完成
        CountDownLatch countLatch = new CountDownLatch(10);

        // 创建一个可缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        try {
            // 先清空
            redisTemplate.delete(secSkuStock);
            redisTemplate.delete(secSuccessUser);

            // 载入商品库存
            secKillService.loadItemStock(1001);

            //脚本执行所需的Key列表，也可以在脚本中直接写死
            List<String> keyList = Lists.newArrayList(secSkuStock, secSuccessUser);
            LOGGER.info("=============开始秒杀=============");
            //有7个人秒杀,有些人秒杀了2次
            for (int i = 0; i < 10; i++) {
                //有些人手快，抢了多次
                int userId = i % 7;
                //进行秒杀
                executorService.submit(new SecKillTask(secKillService, keyList, userId, skuId, switchLatch, countLatch));
            }
            switchLatch.countDown();
            executorService.shutdown();
            countLatch.await();

            //显示秒杀情况
            LOGGER.info("=============秒杀结束=============");
            Map<String, String> gainUserMap = redisTemplate.opsForHash().entries(secSuccessUser);
            gainUserMap.forEach((userId, itemId) -> {
                LOGGER.info("UserId:{},itemId:{}", userId, itemId);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "finish";
    }
}
