package com.imooc.security.core.social;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.social.qq.ImoocSpringSocialConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.sql.DataSource;

/**
 * @类名: SocialConfig<br />
 * @包名：com.imooc.security.core.social.qq<br/>
 * @作者：kevin<br/>
 * @时间：2020/6/1 21:43<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("imooc_");
        return repository;
    }

    @Bean
    public SpringSocialConfigurer imoocSocialSecurityConfig() {
        String filterProcessingUrl = securityProperties.getSocial().getFilterProcessingUrl();
        ImoocSpringSocialConfigurer configurer = new ImoocSpringSocialConfigurer(filterProcessingUrl);
        configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return configurer;
    }
}
