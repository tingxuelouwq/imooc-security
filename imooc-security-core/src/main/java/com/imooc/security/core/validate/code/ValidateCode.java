package com.imooc.security.core.validate.code;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @类名: ValidateCode<br />
 * @包名：com.imooc.security.core.validate.code<br/>
 * @作者：kevin<br/>
 * @时间：2020/5/19 21:48<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class ValidateCode implements Serializable {

    private static final long serialVersionUID = -5160271835783812436L;

    private String code;

    private LocalDateTime expireTime;

    public ValidateCode(String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}