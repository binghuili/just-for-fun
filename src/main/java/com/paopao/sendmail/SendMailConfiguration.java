package com.paopao.sendmail;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 对SpringBoot不能读取自定义文件位置时候配置
 * @ImportResource(locations = {"classpath:beans.xml"})
 *
 * 方法同上
 *@PropertySource(value = {"classpath:beans.properties"})
 *
 * 可以添加@Validatted注解对某个字符的格式（比如在字符上加@EEmail注解）进行验证
 *
 * @EnableAutoConfiguration 我们可以通过启用 debug=true属性；来让控制台打印自动配置报告，这样我们就可以很方便的知道哪些自动配置类生效
 *
 * @author libinghui
 * @date 2018/3/12 20:35
 */

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class SendMailConfiguration {

    private String host;
    private String username;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
