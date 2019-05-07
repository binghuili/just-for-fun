package com.paopao.threadPool.paoPaoThreadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author libinghui
 * @date 2018/4/13 10:38
 */
@Component
public class PaoPaoExecuteThreadPool {

    private static final Logger log = LoggerFactory.getLogger(PaoPaoExecuteThreadPool.class);
    public static Random random = new Random();

    @Async("paopao")
    public void doTaskOne() throws Exception {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        //加延迟为了更清楚看到线程完成状况
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    @Async("paopao")
    public void doTaskTwo() throws Exception {
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    @Async("paopao")
    public void doTaskThree() throws Exception {
        log.info("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (end - start) + "毫秒");
    }

    @Async("paopao")
    public void doTaskFour() throws Exception {
        log.info("开始做任务四");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("完成任务四，耗时：" + (end - start) + "毫秒");
    }

    @Async("paopao")
    public void doTaskFive() throws Exception {
        log.info("开始做任务五");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        log.info("完成任务五，耗时：" + (end - start) + "毫秒");
    }
}
