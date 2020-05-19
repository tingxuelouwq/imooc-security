package com.imooc.security.core.properties;

/**
 * @类名: ImageCodeProperties<br />
 * @包名：com.imooc.security.core.properties<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/26 15:41<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class SmsCodeProperties {

    private int length = 6;     // 短信验证码长度
    private int expireIn = 60;  // 短信验证码过期时间
    private String url;         // 拦截接口url,逗号分隔

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
