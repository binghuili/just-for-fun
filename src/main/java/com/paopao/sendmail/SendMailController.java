package com.paopao.sendmail;

import freemarker.template.Template;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author libinghui
 * @date 2018/3/12 20:33
 */
@Controller
public class SendMailController {

    private static final Logger logger = LoggerFactory.getLogger(SendMailController.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SendMailConfiguration sendMailConfiguration;

    @RequestMapping(value = "/sendMail")
    @ResponseBody
    public String sendSimpleMail() throws Exception {
        logger.info("SendMailController #sendSimpleMail");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sendMailConfiguration.getUsername());
        message.setTo("libinghui_forwork@163.com");
        message.setCc(sendMailConfiguration.getUsername());
        message.setSubject("泡泡");
        message.setText("吐着泡泡\n吐着泡泡\n吐着泡泡\n");
        mailSender.send(message);
        return "success";
    }

    @RequestMapping(value = "/sendHtmlMail")
    public String sendHtmlMail() throws MessagingException {
        logger.info("SendMailController #sendHtmlMail");
        MimeMessage message = null;
        message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sendMailConfiguration.getUsername());
        helper.setTo("libinghui_forwork@163.com");
        helper.setCc(sendMailConfiguration.getUsername());
        helper.setSubject("泡泡");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<h1>泡泡</h1>")
                .append("<p style='color:#33CCCC'>泡泡在左边</p>")
                .append("<p style='text-align:right color:#33CCCC'>泡泡在右边</p>");
        helper.setText(stringBuffer.toString(), true);
        mailSender.send(message);
        return "success";

    }

    @RequestMapping(value = "/sendAttachmentsMail")
    public String sendAttachmentsMail() throws MessagingException {
        logger.info("SendMailController #sendAttachmentsMail");
        MimeMessage message = null;
        message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sendMailConfiguration.getUsername());
        helper.setTo("libinghui_forwork@163.com");
        helper.setCc(sendMailConfiguration.getUsername());
        helper.setSubject("泡泡");
        helper.setText("带附件的邮件内容");
        //注意项目路径问题，自动补用项目路径
        FileSystemResource file = new FileSystemResource(new File("/13051G43618-8.jpg"));
        //加入邮件
        helper.addAttachment("图片.jpg", file);
        mailSender.send(message);
        return "success";
    }

    @RequestMapping(value = "/sendInlineMail")
    public String sendInlineMail() throws MessagingException {
        MimeMessage message = null;
        message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(sendMailConfiguration.getUsername());
        helper.setTo("libinghui_forwork@163.com");
        helper.setCc(sendMailConfiguration.getUsername());
        helper.setSubject("泡泡");
        //第二个参数指定发送的是HTML格式,同时cid:是固定的写法
        helper.setText("<html><body>您的美图:<img src='cid:picture' /></body></html>", true);
        FileSystemResource file = new FileSystemResource(new File("/13051G43618-8.jpg"));
        helper.addInline("picture", file);
        mailSender.send(message);
        return "success";
    }

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @RequestMapping(value = "/sendTemplateMail")
    public String sendTemplateMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sendMailConfiguration.getUsername());
            helper.setTo("libinghui_forwork@163.com");
            helper.setCc(sendMailConfiguration.getUsername());
            helper.setSubject("泡泡");
            Map<String, Object> model = new HashedMap();
            model.put("username", "zggdczfr");

//          修改 application.properties 文件中的读取路径
//          FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//          configurer.setTemplateLoaderPath("classpath:templates");
//          读取html模板

            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.html");
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html, true);
        } catch (Exception e) {

            e.printStackTrace();
        }
        mailSender.send(message);
        return "success";
    }

}
