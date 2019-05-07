//package com.paopao.dingding.controller;
//
//
//import com.paopao.common.PaoPaoException;
//import com.paopao.dingding.service.DingDingService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;
//import org.springframework.core.Ordered;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.ModelAndView;
//import org.yaml.snakeyaml.Yaml;
//
//import java.io.FileInputStream;
//import java.net.URL;
//import java.util.List;
//import java.util.Map;
//
///**
// * 实现Ordered表明执行顺序
// *
// * @author libinghui
// * @date 2018/4/9 13:44
// */
//@ControllerAdvice
//public class GlobalExceptionResolver implements Ordered {
//
//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class);
//
//    @Autowired
//    DingDingService dingDingService;
//    @Autowired
//    DiscoveryClient discoveryClient;
//
//    /**
//     * 自定义异常
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = PaoPaoException.class)
//    public ModelAndView serviceCommonExceptionHandler(PaoPaoException e) {
//        logger.info("GlobalExceptionResolver #serviceCommonExceptionHandler");
//        if (e.getCode() < 0) {
//            return null;
//        }
//        //ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
//        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("");
//        for(ServiceInstance serviceInstance:serviceInstanceList){
//            serviceInstance.
//        }
//        StringBuilder ele = new StringBuilder();
//        for (StackTraceElement elem : e.getStackTrace()) {
//            ele = ele.append(elem.toString() + "\n");
//        }
//        dingDingService.dingDingSendErrorMsg("服务名：" + serviceInstance.getServiceId()
//                + "\n服务地址：" + serviceInstance.getUri()
//                + "\n异常类型：" + e.toString()
//                + "\n具体错误：\n" + ele.toString());
//
//        return null;
//    }
//
//    public String getServiceName() {
//        try {
//            Yaml yaml = new Yaml();
//            URL url = GlobalExceptionResolver.class.getClassLoader().getResource("test.yaml");
//            if (url != null) {
//                //获取test.yaml文件中的配置数据，然后转换为obj，
//                Object obj = yaml.load(new FileInputStream(url.getFile()));
//                System.out.println(obj);
//                //也可以将值转换为Map
//                Map map = (Map) yaml.load(new FileInputStream(url.getFile()));
//                System.out.println(map);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
//
//    /**
//     * 所有异常
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView exceptionHandler(Exception e) {
//        logger.info("GlobalExceptionResolver #exceptionHandler");
//        //获取当前eureka注册信息，discoveryClient.getServices()获取eureka所有注册服务信息
//        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
//        StringBuilder ele = new StringBuilder();
//        for (StackTraceElement elem : e.getStackTrace()) {
//            ele = ele.append(elem.toString() + "\n");
//        }
//        dingDingService.dingDingSendErrorMsg("服务名：" + serviceInstance.getServiceId()
//                + "\n服务地址：" + serviceInstance.getUri()
//                + "\n异常类型：" + e.toString()
//                + "\n具体错误：\n" + ele.toString());
//        return null;
//    }
//
//    @Override
//    public int getOrder() {
//        return Ordered.HIGHEST_PRECEDENCE;
//    }
//
//}
