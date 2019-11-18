package com.imooc.security.core;

import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @类名: SecurityCoreConfig<br />
 * @包名：com.imooc.security.core.properties<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/18 20:46<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
}
