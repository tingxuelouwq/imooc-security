package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @类名: ValidateCodeException<br />
 * @包名：com.imooc.security.core.validate.code<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/26 12:53<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
