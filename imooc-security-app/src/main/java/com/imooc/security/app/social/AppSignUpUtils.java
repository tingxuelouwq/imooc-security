package com.imooc.security.app.social;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;

/**
 * kevin<br/>
 * 2021/3/16 16:08<br/>
 */
@Component
public class AppSignUpUtils {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private UsersConnectionRepository usersConnectionRepository;

    @Autowired
    private ConnectionFactoryLocator connectionFactoryLocator;

    public void saveConnectionData(ServletWebRequest request, ConnectionData connectionData) {
        redisTemplate.opsForValue().set(getKey(request), connectionData, 10, TimeUnit.MINUTES);
    }

    public void doPostSignUp(ServletWebRequest request, String userId) {
        String key = getKey(request);
        if (!redisTemplate.hasKey(key)) {
            throw new RuntimeException("无法找到缓存的用户社交账号信息");
        }
        ConnectionData connectionData = (ConnectionData) redisTemplate.opsForValue().get(key);
        Connection<?> connection = connectionFactoryLocator.getConnectionFactory(connectionData.getProviderId())
                .createConnection(connectionData);
        usersConnectionRepository.createConnectionRepository(userId).addConnection(connection);
        redisTemplate.delete(key);
    }

    private String getKey(ServletWebRequest request) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new RuntimeException("设备id参数不能为空");
        }
        return "imooc:security:social.connect." + deviceId;
    }
}
