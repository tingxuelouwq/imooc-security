package com.imooc.security.core.validate.code.sms;

import com.imooc.security.core.properties.SecurityConstants;
import com.imooc.security.core.validate.code.ValidateCode;
import com.imooc.security.core.validate.code.impl.AbstractValidateCodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 类名: SmsCodeProcessor<br/>
 * 包名：com.imooc.security.core.validate.code.sms<br/>
 * 作者：kevin<br/>
 * 时间：2020/5/20 10:26<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@Component
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    @Autowired
    private SmsCodeSender SmsCodeSender;

    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
        String mobile = ServletRequestUtils.getRequiredStringParameter(
                request.getRequest(), SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE);
        SmsCodeSender.send(mobile, validateCode.getCode());
    }
}
