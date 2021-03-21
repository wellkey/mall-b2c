package com.pzh.portal.module.thread;

import com.pzh.portal.module.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/11 15:47
 * @Version 1.0
 */
public class SecKillTask implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecKillTask.class);

    private SecKillService secKillService;

    private List<String> keyList;

    private long userId;

    private long skuId;

    private CountDownLatch switchLatch;

    private CountDownLatch countLatch;

    public SecKillTask(SecKillService secKillService, List<String> keyList, long userId, long skuId, CountDownLatch switchLatch, CountDownLatch countLatch) {
        this.secKillService = secKillService;
        this.keyList = keyList;
        this.userId = userId;
        this.skuId = skuId;
        this.switchLatch = switchLatch;
        this.countLatch = countLatch;
    }

    @Override
    public void run() {
        try {
            switchLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            String result = secKillService.executeScript("secKill.lua", keyList, userId, skuId);
            switch (Integer.parseInt(result)) {
                case 0:
                    LOGGER.info("UserId:{} 成功抢到 SkuId:{}，时间 {}", userId, skuId, new Date().getTime());
                    break;
                case 1:
                    LOGGER.info("UserId:{} 已经抢到商品 SkuId:{}，不能再抢，时间 {}", userId, skuId, new Date().getTime());
                    break;
                case 2:
                    LOGGER.info("UserId:{} 来迟了，SkuId:{} 已被抢光，时间 {}",  userId, skuId, new Date().getTime());
                    break;
                default:
                    LOGGER.info("Illegal Result: {}", result);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countLatch.countDown();
        }
    }
}
