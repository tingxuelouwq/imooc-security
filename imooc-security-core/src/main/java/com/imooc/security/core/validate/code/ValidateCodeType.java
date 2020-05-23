package com.imooc.security.core.validate.code;

import com.imooc.security.core.properties.SecurityConstants;

/**
 * @类名: ValidateCodeType<br />
 * @包名：com.imooc.security.core.validate.code<br/>
 * @作者：kevin<br/>
 * @时间：2020/5/23 14:30<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public enum ValidateCodeType {
    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取参数名称
     */
    public abstract String getParamNameOnValidate();
}
