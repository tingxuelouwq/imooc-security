package com.imooc.security.core.social.qq;

/**
 * 类名: QQUserInfo<br/>
 * 包名：com.imooc.security.core.social.qq<br/>
 * 作者：kevin<br/>
 * 时间：2020/5/25 15:27<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class QQUserInfo {

    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private String gender;
    /**
     * 大小为40×40像素的QQ头像URL
     */
    private String figureurl_qq_1;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public void setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
    }

    @Override
    public String toString() {
        return "QQUserInfo{" +
                "nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", figureurl_qq_1='" + figureurl_qq_1 + '\'' +
                '}';
    }
}
