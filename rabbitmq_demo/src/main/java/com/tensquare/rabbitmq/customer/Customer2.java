package com.tensquare.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/23 10:57
 * Description:
 **/
@Component
@RabbitListener(queues = "itheima")
public class Customer2 {
    @RabbitHandler
    public void showMessage(String message){
        System.out.println("itheima收到消息："+message);
    }
}
