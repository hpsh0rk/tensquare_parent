package com.tensquare.sms.util;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * User: sh0rk
 * Email:sh0rk@qq.com
 * Date: 2019/2/23 23:56
 * Description:
 **/
@Component
public class SmsUtil {
    // 短信应用SDK AppID
    static final int appid = 1400009099; // 1400开头

    // 短信应用SDK AppKey
    static final String appkey = "9ff91d87c2cd7cd0ea762f141975d1df37481d48700d70ac37470aefc60f9bad";

    // 需要发送短信的手机号码
    static final String phoneNumber = "10086";

    // 短信模板ID，需要在短信应用中申请
    static final int templateId = 7839; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    //templateId7839对应的内容是"您的验证码是: {1}"
// 签名
    static final String smsSign = "腾讯云"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
    public static void sendSms() {

        String[] params = {"5678"};
        SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
        SmsSingleSenderResult result;

        {
            try {
                result = ssender.sendWithParam("86", phoneNumber, templateId, params, smsSign, "", "");
                System.out.println(result);
            } catch (HTTPException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
