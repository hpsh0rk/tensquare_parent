package com.tensquare.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/23 10:34
 * Description:
 **/
@Component
@RabbitListener(queues = "itcast")
public class Customer1 {
    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("3333直接消费模式消费：" + message);
    }
}
