package com.imooc.security.core.social.qq.connect;

import com.imooc.security.core.social.qq.api.QQ;
import com.imooc.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @类名: QQApiAdapter<br />
 * @包名：com.imooc.security.core.social.qq.connect<br/>
 * @作者：kevin<br/>
 * @时间：2020/6/1 16:05<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class QQApiAdapter implements ApiAdapter<QQ> {

    /**
     * 测试api是否可用
     * @param api
     * @return
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    /**
     * 适配api数据和connection数据
     * @param api
     * @param values
     */
    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();
        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        values.setProfileUrl(null); // 个人主页地址
        values.setProviderUserId(userInfo.getOpenId()); // 服务提供商的用户id，即openid
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {
        // do nothing
    }
}
