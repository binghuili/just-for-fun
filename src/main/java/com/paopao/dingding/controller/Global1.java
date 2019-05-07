package com.paopao.dingding.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author libinghui
 * @date 2018/4/9 14:16
 */
public class Global1 implements HandlerExceptionResolver, Ordered {

    private static Logger logger = LoggerFactory.getLogger(Global1.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object handler,
                                         Exception ex) {
        logger.info("Global1 #resolveException ex", ex);
        ModelAndView mv = new ModelAndView(errorView());
        mv.addObject("exception", ex);
        logger.info("经过这个方法了1!");
        return mv;
    }

    /**
     * 最高优先级
     *
     * @return
     */
    @Override
    public int getOrder() {
        return -2147483647;
    }

    /**
     * 错误处理页面的默认实现
     *
     * @return
     */
    public String errorView() {
        return "/error";
    }

}
