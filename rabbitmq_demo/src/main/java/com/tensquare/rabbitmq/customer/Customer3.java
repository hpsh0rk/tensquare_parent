package com.tensquare.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/23 10:58
 * Description:
 **/
@Component
@RabbitListener(queues = "kudingyu")
public class Customer3 {
    @RabbitHandler
    public void showMessage(String message){
        System.out.println("kudingyu收到了消息："+message);
    }
}
