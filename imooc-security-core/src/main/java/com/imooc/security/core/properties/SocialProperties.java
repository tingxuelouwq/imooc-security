package com.imooc.security.core.properties;

/**
 * @类名: SocialProperties<br />
 * @包名：com.imooc.security.core.properties<br/>
 * @作者：kevin<br/>
 * @时间：2020/6/2 21:08<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class SocialProperties {

    private QQProperties qq = new QQProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}