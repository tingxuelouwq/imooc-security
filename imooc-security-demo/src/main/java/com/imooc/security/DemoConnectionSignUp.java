package com.imooc.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * kevin<br/>
 * 2020/6/13 9:46<br/>
 */
//@Component
public class DemoConnectionSignUp implements ConnectionSignUp {
    @Override
    public String execute(Connection<?> connection) {
        // 根据社交用户信息默认创建用户并返回用户唯一标识
        return connection.getDisplayName();
    }
}
