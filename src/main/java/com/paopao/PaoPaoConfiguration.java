package com.paopao;

import com.paopao.dingding.controller.Global1;
import com.paopao.dingding.controller.Global2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author libinghui
 * @date 2018/4/10 8:43
 */
@Configuration
public class PaoPaoConfiguration {

    /**
     * 关于全局异常处理的配置
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(Global2.class)
    public Global2 global2ExceptionResolver() {
        return new Global2();
    }

    /**
     * 关于全局异常处理的配置
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(Global1.class)
    public Global1 global1ExceptionResolver() {
        return new Global1();
    }

    /**
     * 关于自定义线程池的配置
     * @return
     */
    @EnableAsync
    @Configuration
    class PaoPaoThreadPool {
        @Bean("paopao")
        public Executor taskExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            //核心线程数10：线程池创建时候初始化的线程数
            executor.setCorePoolSize(2);
            //最大线程数20：线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
            executor.setMaxPoolSize(4);
            //缓冲队列200：用来缓冲执行任务的队列
            executor.setQueueCapacity(2);
            //允许线程的空闲时间60秒：当超过了核心线程出之外的线程在空闲时间到达之后会被销毁
            executor.setKeepAliveSeconds(60);
            //线程池名的前缀：设置好了之后可以方便我们定位处理任务所在的线程池
            executor.setThreadNamePrefix("paopao-");
            executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
            return executor;
        }
    }
}
