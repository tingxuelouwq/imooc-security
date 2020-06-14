package com.imooc.security.core.social.weixin.api;

/**
 * kevin<br/>
 * 2020/6/13 22:33<br/>
 */
public interface Weixin {

    WeixinUserInfo getUserInfo(String openId);
}
