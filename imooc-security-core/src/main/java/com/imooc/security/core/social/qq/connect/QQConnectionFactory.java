package com.imooc.security.core.social.qq.connect;

import com.imooc.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @类名: QQConnectionFactory<br />
 * @包名：com.imooc.security.core.social.qq.connect<br/>
 * @作者：kevin<br/>
 * @时间：2020/6/1 21:35<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQApiAdapter());
    }
}
