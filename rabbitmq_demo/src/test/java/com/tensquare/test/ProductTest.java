package com.tensquare.test;

import com.tensquare.rabbitmq.RabbitMQApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.peer.ScrollbarPeer;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/23 10:30
 * Description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class ProductTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("itcast","直接连接测试");
    }

    @Test
    public void testSendFanout(){
        rabbitTemplate.convertAndSend("chuanzhi","","分裂模式测试");
    }

    @Test
    public void testSendTopic(){
        rabbitTemplate.convertAndSend("topic84","good.abc.log","主题模式测试");
    }
}
