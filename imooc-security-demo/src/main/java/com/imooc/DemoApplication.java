package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 类名: DemoApplication<br/>
 * 包名：com.imooc<br/>
 * 作者：kevin<br/>
 * 时间：2019/8/27 11:02<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@EnableAsync
@SpringBootApplication/*(exclude = {SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class})*/
@EnableSwagger2
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
