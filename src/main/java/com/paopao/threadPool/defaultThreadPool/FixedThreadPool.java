package com.paopao.threadPool.defaultThreadPool;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author libinghui
 * @date 2018/3/28 9:31
 */
@RestController
public class FixedThreadPool {

    private ExecutorService pool = null;

    @RequestMapping(value = "/threadPool")
    public void test22() {
        for (int i = 0; i < 100; i++) {
            test21(i);
        }
    }

    /**
     * 可以执行 但不保证执行顺序
     * @param i
     */
    private void test21(int i) {
        pool.submit(() -> {
            System.out.println(i);
        });
    }

    @PostConstruct
    public void init() throws Exception {
        pool = Executors.newFixedThreadPool(5);
    }

    @PreDestroy
    public void destroy() throws Exception {
        pool.shutdown();
    }
}

