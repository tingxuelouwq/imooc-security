package com.imooc.security.core.social.qq;

/**
 * 类名: QQAccessToken<br/>
 * 包名：com.imooc.security.core.social.qq<br/>
 * 作者：kevin<br/>
 * 时间：2020/5/25 15:18<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class QQAccessToken {

    /**
     * 授权AccessToken
     */
    private String accessToken;
    /**
     * AccessToken的有效期，单位为妙
     */
    private Integer expiresIn;
    /**
     * 在授权自动续期步骤中，获取新的AccessToken时需要提供的参数
     */
    private String refreshToken;

    public QQAccessToken(String accessToken, Integer expiresIn, String refreshToken) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "QQAccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", refreshToken='" + refreshToken + '\'' +
                '}';
    }
}
