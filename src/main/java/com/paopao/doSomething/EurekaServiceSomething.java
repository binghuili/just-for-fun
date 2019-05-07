package com.paopao.doSomething;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author libinghui
 * @date 2018/4/10 10:39
 */
@RestController
public class EurekaServiceSomething {
    private static final Logger logger = LoggerFactory.getLogger(EurekaServiceSomething.class);
    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/service")
    public void test1() {
        List<String> list = discoveryClient.getServices();
        for (String s : list) {
            System.out.println(s);
        }
    }

}
