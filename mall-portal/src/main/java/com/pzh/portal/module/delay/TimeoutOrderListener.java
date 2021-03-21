package com.pzh.portal.module.delay;

import com.pzh.portal.module.dao.OrderDao;
import com.pzh.portal.module.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 14:57
 * @Version 1.0
 */
@Component
@RabbitListener(queues = "order.dlk.queue")
public class TimeoutOrderListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeoutOrderListener.class);

    @Autowired
    private OrderDao orderDao;

    @RabbitHandler
    public void receive(String str) {
        LOGGER.info("超时订单id：" + str);
        long id = Long.parseLong(str);
        Order order = orderDao.getOrderById(id);

        // 订单超时过期
        if (order.getStatus() == 1) {
            orderDao.updateOrderStatus(id, 6);
        }
    }
}
