package com.imooc.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * kevin<br/>
 * 2020/6/13 22:20<br/>
 */
public class WeixinProperties extends SocialProperties {

    private String providerId = "weixin";

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }
}
