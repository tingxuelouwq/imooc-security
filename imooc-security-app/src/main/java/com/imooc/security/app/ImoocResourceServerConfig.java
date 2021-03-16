package com.imooc.security.app;

import com.imooc.security.app.social.openid.OpenIdAuthenticationSecurityConfig;
import com.imooc.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.imooc.security.core.properties.SecurityConstants;
import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validate.code.ValidateCodeSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * kevin<br/>
 * 2020/8/16 20:54<br/>
 */
@Configuration
@EnableResourceServer
public class ImoocResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private ValidateCodeSecurityConfig validateCodeSecurityConfig;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SpringSocialConfigurer imoocSocialSecurityConfig;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        applyPasswordAuthenticationConfig(http);

        http
            .apply(validateCodeSecurityConfig)
            .and()
            .apply(smsCodeAuthenticationSecurityConfig)
                .and()
            .apply(imoocSocialSecurityConfig)
                .and()
            .apply(openIdAuthenticationSecurityConfig)
                .and()
            .authorizeRequests()
                .antMatchers(
                    SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                    securityProperties.getBrowser().getLoginPage(),
                    SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
                    securityProperties.getBrowser().getSignUpUrl(),
                    securityProperties.getBrowser().getSession().getSessionInvalidUrl(),
                    securityProperties.getBrowser().getSignOutUrl(),
                    "/user/regist", "/social/signUp")
                    .permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .csrf().disable();
    }

    public void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);
    }
}
