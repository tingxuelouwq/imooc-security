package com.imooc.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * kevin<br/>
 * 2021/3/16 11:01<br/>
 */
public interface SocialAuthenticationFilterPostProcessor {

    void process(SocialAuthenticationFilter socialAuthenticationFilter);
}
