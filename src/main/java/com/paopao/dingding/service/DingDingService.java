package com.paopao.dingding.service;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.paopao.dingding.model.At;
import com.paopao.dingding.model.DingDingMsg;
import com.paopao.dingding.model.Text;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author libinghui
 * @date 2018/4/8 11:30
 */
@Service
public class DingDingService {

    private static final Logger logger = LoggerFactory.getLogger(DingDingService.class);

    public void dingDingSendErrorMsg(String errorMsg) {
        logger.info("DingDingService #dingDingSendErrorMsg errorMsg={}", errorMsg);

        String url = "https://oapi.dingtalk.com/robot/send?access_token=c6bf4bf16cb926d53ab7b33525c4e7bae922a974b77763414d9bb8a8499a80f2";
        logger.info("url={}", url);
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");

        //String textMsg = "{ \"msgtype\": \"text\", \"text\": {\"content\": \"报错啦!\"}}";
        StringEntity se = new StringEntity(JSON.toJSONString(getDingDingMsg(errorMsg)), "utf-8");
        httppost.setEntity(se);

        try {
            HttpResponse response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = EntityUtils.toString(response.getEntity(), "utf-8");
                logger.info("result={}", result);
            }
        } catch (IOException e) {
            logger.info("钉钉异常!");
        }
    }

    private DingDingMsg getDingDingMsg(String errorMsg) {
        logger.info("DingDingService #getDingDingMsg");
        DingDingMsg dingDingMsg = new DingDingMsg();
        dingDingMsg.setMsgtype("text");
        Text text = new Text();
        text.setContent(errorMsg);
        dingDingMsg.setText(text);
        At at = new At();
        at.setAtMobiles(new String[]{"13810166993", "18605374162", "18910358627", "18811727430"});
        at.setAtAll(true);
        dingDingMsg.setAt(at);
        logger.info("dingDingMsg={}", JSON.toJSONString(dingDingMsg));
        return dingDingMsg;
    }

}
