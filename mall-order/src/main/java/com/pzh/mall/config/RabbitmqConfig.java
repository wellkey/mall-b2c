package com.pzh.mall.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/13 15:48
 * @Version 1.0
 */
@Configuration
public class RabbitmqConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    //死信交换机，队列，路由相关配置
    public static final String DLK_EXCHANGE = "order.dlk.exchange";
    public static final String DLK_ROUTEKEY = "order.dlk.routeKey";
    public static final String DLK_QUEUE = "order.dlk.queue";

    //业务交换机，队列，路由相关配置
    public static final String DEMO_EXCHANGE = "order.demo.exchange";
    public static final String DEMO_QUEUE = "order.demo.queue";
    public static final String DEMO_ROUTEKEY = "order.demo.routeKey";

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        return rabbitTemplate;
    }


    @Bean
    public DirectExchange demoExchange(){
        return new DirectExchange(DEMO_EXCHANGE,true,false);
    }

    @Bean
    public Queue demoQueue(){
        //只需要在声明业务队列时添加x-dead-letter-exchange，值为死信交换机
        Map<String,Object> map = new HashMap<>(1);
        map.put("x-dead-letter-exchange", DLK_EXCHANGE);
        //该参数x-dead-letter-routing-key可以修改该死信的路由key，不设置则使用原消息的路由key
        map.put("x-dead-letter-routing-key", DLK_ROUTEKEY);
        return new Queue(DEMO_QUEUE,true,false,false, map);
    }

    @Bean
    public Binding demoBind(){
        return BindingBuilder.bind(demoQueue()).to(demoExchange()).with(DEMO_ROUTEKEY);
    }

    @Bean
    public DirectExchange dlkExchange(){
        return new DirectExchange(DLK_EXCHANGE,true,false);
    }

    @Bean
    public Queue dlkQueue(){
        return new Queue(DLK_QUEUE,true,false,false);
    }

    @Bean
    public Binding dlkBind(){
        return BindingBuilder.bind(dlkQueue()).to(dlkExchange()).with(DLK_ROUTEKEY);
    }

}
