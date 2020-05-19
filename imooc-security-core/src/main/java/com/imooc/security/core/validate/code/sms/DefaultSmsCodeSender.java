package com.imooc.security.core.validate.code.sms;

/**
 * @类名: DefaultSmsCodeSender<br />
 * @包名：com.imooc.security.core.validate.code.sms<br/>
 * @作者：kevin<br/>
 * @时间：2020/5/19 22:10<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }
}
