package com.imooc.exception;

/**
 * @类名: UserNotExistException<br />
 * @包名：com.imooc.exception<br/>
 * @作者：kevin<br/>
 * @时间：2019/9/10 22:39<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class UserNotExistException extends RuntimeException {

    private String id;

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
