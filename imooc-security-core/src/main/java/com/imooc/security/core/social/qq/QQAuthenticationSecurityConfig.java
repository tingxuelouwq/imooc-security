package com.imooc.security.core.social.qq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 类名: WebSecurityConfig<br/>
 * 包名：com.imooc.security.core.social.qq<br/>
 * 作者：kevin<br/>
 * 时间：2020/5/25 16:04<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@Configuration
public class QQAuthenticationSecurityConfig extends
        SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler imoocAuthenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        QQAuthenticationFilter qqAuthenticationFilter = new QQAuthenticationFilter();
        qqAuthenticationFilter.setAuthenticationSuccessHandler(imoocAuthenticationSuccessHandler);
        qqAuthenticationFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        qqAuthenticationFilter.setAuthenticationManager(new QQAuthenticationManager());
        http.addFilterBefore(qqAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
