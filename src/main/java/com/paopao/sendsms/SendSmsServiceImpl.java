package com.paopao.sendsms;

import org.springframework.stereotype.Service;

/**
 * @author libinghui
 * @date 2019/1/23 14:16
 */
@Service
public class SendSmsServiceImpl implements SendSmsService {

    // 短信应用SDK AppID
    // 1400开头
    static int appid = 1400;
    // 短信应用SDK AppKey
    static String appkey = "xxxxxxxxxx";
    // 需要发送短信的手机号码
    static String[] phoneNumbers = {"xxxxxxxx"};
    // 短信模板ID，需要在短信应用中申请
    // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请
    int templateId = 7839;
    // 签名
    // NOTE:
    String smsSign = "码神联盟";
    // 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`

    @Override
    public void sendSms() {
        //SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
        //SmsSingleSenderResult result = ssender.send(0, "86", phoneNumbers[0], "324562为您的登录验证码，请于2分钟内填写。如非本人操作，请忽略本短信。", "", "");
    }
}
