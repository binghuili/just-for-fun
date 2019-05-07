package com.paopao.threadPool.paoPaoThreadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libinghui
 * @date 2018/4/13 10:46
 */
@RestController
public class ThreadPoolController {

    @Autowired
    private PaoPaoExecuteThreadPool paoPaoExecuteThreadPool;

    @RequestMapping("/pool")
    public void test() throws Exception {
        paoPaoExecuteThreadPool.doTaskOne();
        paoPaoExecuteThreadPool.doTaskTwo();
        paoPaoExecuteThreadPool.doTaskThree();
        paoPaoExecuteThreadPool.doTaskFour();
        paoPaoExecuteThreadPool.doTaskFive();
        Thread.currentThread().join();
    }

}
