package com.imooc.security.core.social.qq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名: QQAuthenticationManager<br/>
 * 包名：com.imooc.security.core.social.qq<br/>
 * 作者：kevin<br/>
 * 时间：2020/5/25 15:56<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class QQAuthenticationManager implements AuthenticationManager {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final List<GrantedAuthority> AUTHORITIES = new ArrayList<>();

    /**
     * 获取用户信息
     */
    private static final String USER_INFO_URL = "https://graph.qq.com/user/get_user_info?access_token=%s&oauth_consumer_key=%s&openid=%s";

    /**
     * client_id 由腾讯提供(即AppId)
     */
    private static final String CLIENT_ID = "101364240";

    private ObjectMapper objectMapper = new ObjectMapper();

    static {
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        QQUserInfo qqUserInfo = null;
        if (authentication.getName() != null && authentication.getCredentials() != null) {
            qqUserInfo = getUserInfo(authentication.getName(), (String) authentication.getCredentials());
        }
        return new UsernamePasswordAuthenticationToken(qqUserInfo, null, AUTHORITIES);
    }

    /**
     * 获取QQ授权后的用户基本信息
     * @param accessToken
     * @param openId
     * @return
     */
    private QQUserInfo getUserInfo(String accessToken, String openId) {
        String url = String.format(USER_INFO_URL, accessToken, CLIENT_ID, openId);
        RestTemplate template = new RestTemplate();
        String resp = template.getForObject(url, String.class);
        logger.info("获取用户信息的响应：" + resp);

        QQUserInfo userInfo = null;
        try {
            return objectMapper.readValue(resp, QQUserInfo.class);
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
    }
}
