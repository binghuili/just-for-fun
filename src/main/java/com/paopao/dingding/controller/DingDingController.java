package com.paopao.dingding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libinghui
 * @date 2018/4/8 14:55
 */
@RequestMapping
@RestController
public class DingDingController {

    @RequestMapping(value = "/dingding")
    public void dingTest() throws Exception {
        int m = 0;
        int n = 3;
        int i = n / m;
    }

}
