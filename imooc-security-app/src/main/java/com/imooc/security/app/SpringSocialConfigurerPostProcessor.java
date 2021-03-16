package com.imooc.security.app;

import com.imooc.security.core.social.ImoocSpringSocialConfigurer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * kevin<br/>
 * 2021/3/16 16:42<br/>
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName, "imoocSocialSecurityConfig")) {
            ImoocSpringSocialConfigurer configurer = (ImoocSpringSocialConfigurer) bean;
            configurer.signupUrl("/social/signUp");
            return configurer;
        }
        return bean;
    }
}
