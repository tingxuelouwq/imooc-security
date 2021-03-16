package com.imooc.security.core.support;

/**
 * kevin<br/>
 * 2020/6/11 22:41<br/>
 */
public class SocialUserInfo {

    private String providerId;      // 服务提供商id
    private String providerUserId;  // openid
    private String nickname;        // 昵称
    private String headimg;         // 头像

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }
}
