package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 类名: ValidateCodeProcessor<br/>
 * 包名：com.imooc.security.core.validate.code<br/>
 * 作者：kevin<br/>
 * 时间：2020/5/20 9:52<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入Session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 创建验证码
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验验证码
     * @param request
     */
    void validate(ServletWebRequest request);
}
