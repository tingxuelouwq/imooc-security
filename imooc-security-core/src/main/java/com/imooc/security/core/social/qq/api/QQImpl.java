package com.imooc.security.core.social.qq.api;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;

/**
 * @类名: QQImpl<br />
 * @包名：com.imooc.security.core.social.qq.api<br/>
 * @作者：kevin<br/>
 * @时间：2020/5/27 22:29<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
    @Override
    public QQUserInfo getUserInfo() {
        return null;
    }
}
