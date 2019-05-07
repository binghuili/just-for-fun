package com.paopao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author libinghui
 * @time 2018/2/27 15:11
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class JustForFunApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustForFunApplication.class, args);
    }

    @Configuration
    public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll()
                    .and().csrf().disable();
        }

    }

}
