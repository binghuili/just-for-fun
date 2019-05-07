import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author libinghui
 * @date 2018/4/27 10:56
 */
public class test4 {


    @Test
    public void test() {
        int n = 0;
        int m = 3;
        int i = m / n;
    }

    @Test
    public void test1() {
        Integer n = 128;
        Integer m = 128;
        int o = 128;
        System.out.println(n==m);
        System.out.println(n==o);
        System.out.println(n.equals(m));
        System.out.println(n.equals(o));
    }

    @Service
    public class NoticeErrorExceptionResolver implements HandlerExceptionResolver, Ordered {

        private ExecutorService pool = null;

        @PreDestroy
        public void destroy() throws Exception {
            pool.shutdown();
        }

        @PostConstruct
        public void init() throws Exception {
            pool = Executors.newFixedThreadPool(5);
        }

        /**
         * 线程池处理告警消息
         *
         * @param errorMsg
         */
        public void process(String errorMsg) {
            pool.submit(() -> {
                sendErrorMsgNotice(errorMsg);
            });
        }

        @Override
        public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object handler,
                                             Exception ex) {
            try {
                //判断异常类型
                StringBuilder ele = new StringBuilder();
                String errorTypeMsg = "";
                //拼接报警信息
                for (StackTraceElement elem : ex.getStackTrace()) {
                    ele.append(elem.toString()).append("\n");
                }
                errorTypeMsg = ex.toString();

                String errorMsg = "hello";

                //调用线程池处理告警信息发送
                process(errorMsg);
            } catch (Exception e2) {
            }
            return null;
        }

        /**
         * 最高优先级
         *
         * @return
         */
        @Override
        public int getOrder() {
            return Ordered.HIGHEST_PRECEDENCE;
        }

    }

    public void sendErrorMsgNotice(String errorMsg) {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://oapi.dingtalk.com/robot/send?access_token=c6bf4bf16cb926d53ab7b33525c4e7bae922a974b77763414d9bb8a8499a80f2");
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");

        StringEntity se = new StringEntity(JSON.toJSONString(errorMsg), "utf-8");
        httppost.setEntity(se);
        HttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

