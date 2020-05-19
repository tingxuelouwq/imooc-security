package com.imooc.security.core.validate.code.sms;

/**
 * @类名: SmsCodeSender<br />
 * @包名：com.imooc.security.core.validate.code.sms<br/>
 * @作者：kevin<br/>
 * @时间：2020/5/19 22:09<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public interface SmsCodeSender {
    void send(String mobile, String code);
}
