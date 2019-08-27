package com.imooc.dto;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * 类名: User<br/>
 * 包名：com.imooc.dto<br/>
 * 作者：kevin<br/>
 * 时间：2019/8/27 18:48<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class User {

    public interface UserSimpleView {}
    public interface UserDetailView extends UserSimpleView {}

    private String username;
    private String password;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
