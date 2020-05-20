package com.imooc.security.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @类名: SmsCodeAuthenticationProvider<br />
 * @包名：com.imooc.security.core.authentication.mobile<br/>
 * @作者：kevin<br/>
 * @时间：2020/5/20 23:04<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
