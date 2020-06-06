package com.imooc.security.core.social.qq;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * kevin<br/>
 * 2020/6/6 18:11<br/>
 */
public class ImoocSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessingUrl;

    public ImoocSpringSocialConfigurer(String filterProcessingUrl) {
        this.filterProcessingUrl = filterProcessingUrl;
    }

    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessingUrl);
        return (T) filter;
    }
}
