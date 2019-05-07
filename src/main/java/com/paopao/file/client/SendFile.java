package com.paopao.file.client;

import com.paopao.file.server.InMemoryMultipartFile;
import com.paopao.file.server.InnerFileFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * @author libinghui
 * @date 2018/3/7 10:17
 */

/**
 * @RestController 等同于@Controller+@ResponseBody 对比@Controller必须返回信息 @RestController 不需要
 */
@RestController
@RequestMapping(value = "/tribe/api/file")
public class SendFile {
    private static final Logger logger = LoggerFactory.getLogger(SendFile.class);
//
//    @Autowired
//    private InnerFileFeignClient innerFileFeignClient;
//
//    @RequestMapping(value = "/file", method = RequestMethod.POST)
//    public void sendFiles() {
//        String string = "UUID含义是通用唯一识别码 (Universally Unique Identifier)，这是一个软件建构的标准，也是被开源软件基金会 (Open Software Foundation, OSF) 的组织应用在分布式计算环境 (Distributed Computing Environment, DCE) 领域的一部分。";
//        byte[] bytes = string.getBytes();
//        MultipartFile file = new InMemoryMultipartFile("filename.text", bytes);
//        innerFileFeignClient.innerUploadFile(file);
//    }
//
//    @RequestMapping(value = "/jpgfile", method = RequestMethod.POST)
//    public String sendJpgFiles() {
//        logger.info("SendFile #sendJpgFiles");
//        byte[] data = null;
//        FileImageInputStream input = null;
//        try {
//            input = new FileImageInputStream(new File("/home/tribe/13051G43618-8.jpg"));
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//            byte[] buf = new byte[1024];
//            int numBytesRead = 0;
//            while ((numBytesRead = input.read(buf)) != -1) {
//                output.write(buf, 0, numBytesRead);
//            }
//            data = output.toByteArray();
//            output.close();
//            input.close();
//        } catch (Exception ex1) {
//            ex1.printStackTrace();
//        }
//        MultipartFile file = new InMemoryMultipartFile("JinJiDeJuRen.jpg", data);
//        return innerFileFeignClient.innerUploadFile(file).getData();
//    }

}
