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

    private String filterProcessingUrl = "/auth";

    private QQProperties qq = new QQProperties();

    private WeixinProperties weixin = new WeixinProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }

    public String getFilterProcessingUrl() {
        return filterProcessingUrl;
    }

    public void setFilterProcessingUrl(String filterProcessingUrl) {
        this.filterProcessingUrl = filterProcessingUrl;
    }

    public WeixinProperties getWeixin() {
        return weixin;
    }

    public void setWeixin(WeixinProperties weixin) {
        this.weixin = weixin;
    }
}
