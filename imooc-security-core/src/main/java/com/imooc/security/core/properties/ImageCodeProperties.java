package com.imooc.security.core.properties;

/**
 * @类名: ImageCodeProperties<br />
 * @包名：com.imooc.security.core.properties<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/26 15:41<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class ImageCodeProperties {

    private int width = 67;     // 图片验证码宽度
    private int height = 23;    // 图片验证码高度
    private int length = 4;     // 图片验证码位数
    private int expireIn = 60;  // 图片验证码过期时间
    private String url;         // 拦截接口url,逗号分隔

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

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
