package com.imooc.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名: UserQueryCondition<br/>
 * 包名：com.imooc.dto<br/>
 * 作者：kevin<br/>
 * 时间：2019/8/27 18:53<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class UserQueryCondition {

    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "用户年龄")
    private String age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
