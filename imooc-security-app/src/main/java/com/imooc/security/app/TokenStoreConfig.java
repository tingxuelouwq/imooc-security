package com.imooc.security.app;

import com.imooc.security.app.jwt.ImoocJwtTokenEnhancer;
import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * kevin<br/>
 * 2021/3/17 14:31<br/>
 */
@Configuration
public class TokenStoreConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * 如果配置文件中属性imooc.security.oauth2.storeType的值为redis时, 此项配置生效
     */
    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "imooc.security.oauth2", name = "storeType", havingValue = "redis")
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * 如果配置文件中没有属性imooc.security.oauth2.storeType(matchIsMissing=true的含义), 或者该属性值为jwt时, 此项配置生效
     */
    @Configuration
    @ConditionalOnProperty(prefix = "imooc.security.oauth2", name = "storeType", havingValue = "jwt", matchIfMissing = true)
    public static class JwtTokenConfig {

        @Autowired
        private SecurityProperties securityProperties;

        /**
         * 存取JWT
         */
        @Bean
        public TokenStore jwtTokenStore() {
            return new JwtTokenStore(jwtAccessTokenConverter());
        }

        /**
         * JWT生成处理
         */
        @Bean
        public JwtAccessTokenConverter jwtAccessTokenConverter() {
            JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
            accessTokenConverter.setSigningKey(securityProperties.getOauth2().getJwtSigningKey());
            return accessTokenConverter;
        }

        @Bean
        @ConditionalOnMissingBean(name = "jwtTokenEnhancer")
        public TokenEnhancer jwtTokenEnhancer() {
            return new ImoocJwtTokenEnhancer();
        }
    }
}
