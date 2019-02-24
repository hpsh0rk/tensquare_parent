package com.tensquare.sms.listener;

import com.tensquare.sms.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/23 14:20
 * Description:
 **/
@Component
@RabbitListener(queues = "sms")
public class SmsListener {
    @Autowired
    private SmsUtil smsUtil;

    @RabbitHandler
    public void executeSms(Map<String,String> map){
        String mobile = map.get("mobile");
        String code = map.get("checkCode");
        System.out.println("手机号："+map.get("mobile"));
        System.out.println("验证码"+map.get("checkCode"));
        smsUtil.sendSms(mobile,code);
    }
}
