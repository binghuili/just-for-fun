package com.paopao.sendsms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libinghui
 * @date 2019/1/23 14:09
 */
@RestController
public class SendSmsController {

    @Autowired
    SendSmsService sendSmsService;

    @RequestMapping("/sendsms")
    public void sendSms() {
        sendSmsService.sendSms();
    }

}
