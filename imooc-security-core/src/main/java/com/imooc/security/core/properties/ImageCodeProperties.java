package com.imooc.security.core.properties;

/**
 * @类名: ImageCodeProperties<br />
 * @包名：com.imooc.security.core.properties<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/26 15:41<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class ImageCodeProperties extends SmsCodeProperties {

    private int width = 67;     // 图片验证码宽度
    private int height = 23;    // 图片验证码高度

    public ImageCodeProperties() {
        setLength(4);           // 图片验证码长度
    }

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
}
