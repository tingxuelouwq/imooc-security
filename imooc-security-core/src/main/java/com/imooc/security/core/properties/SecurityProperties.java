package com.imooc.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @类名: SecurityProperties<br />
 * @包名：com.imooc.security.core.properties<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/18 20:43<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
