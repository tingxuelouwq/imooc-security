package com.imooc.security.core.social.qq;

import com.imooc.security.core.properties.SecurityConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类名: QQAuthenticationFilter<br/>
 * 包名：com.imooc.security.core.social.qq<br/>
 * 作者：kevin<br/>
 * 时间：2020/5/25 15:02<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
public class QQAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * response_type 返回类型
     */
    private final static String RESPONSE_TYPE = "code";

    /**
     * grant_type 由腾讯提供
     */
    private final static String GRANT_TYPE = "authorization_code";

    /**
     * client_id 由腾讯提供(即AppId)
     */
    static final String CLIENT_ID = "101364240";

    /**
     * client_secret 由腾讯提供(即App Key)
     */
    private final static String CLIENT_SECRET = "ef27b7a6ca651a3609dd47f21e385955";

    /**
     * redirect_uri 腾讯回调地址
     */
    private final static String REDIRECT_URI = "http://127.0.0.1/login/qq";

    /**
     * 获取 access_token_url 的 API
     */
    private final static String ACCESS_TOKEN_URL = "https://graph.qq.com/oauth2.0/token";

    /**
     * 获取 OpenID url地址
     */
    private final static String OPENID_URL = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    /**
     * 获取 token 的地址拼接
     */
    private final static String TOKEN_ACCESS_API = "%s?grant_type=%s&client_id=%s&client_secret=%s&code=%s&redirect_uri=%s";

    public QQAuthenticationFilter() {
        super(new AntPathRequestMatcher(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_QQ, "GET"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        UsernamePasswordAuthenticationToken authenticationToken = null;
        String authorizationCode = request.getParameter(RESPONSE_TYPE);
        String accessTokenUrl = String.format(TOKEN_ACCESS_API, ACCESS_TOKEN_URL, GRANT_TYPE, CLIENT_ID, CLIENT_SECRET, authorizationCode, REDIRECT_URI);
        QQAccessToken qqAccessToken = getQQAccessToken(accessTokenUrl);
        if (qqAccessToken != null) {
            String openId = getOpenId(qqAccessToken.getAccessToken());
            if (openId != null) {
                authenticationToken = new UsernamePasswordAuthenticationToken(qqAccessToken.getAccessToken(), openId);
            }
        }
        return this.getAuthenticationManager().authenticate(authenticationToken);
    }

    /**
     * 获取用户的唯一OpenId
     *
     * @param accessToken
     * @return
     */
    private String getOpenId(String accessToken) {
        RestTemplate template = new RestTemplate();
        String openIdUrl = String.format(OPENID_URL, accessToken);
        String resp = template.getForObject(openIdUrl, String.class);
        logger.info("获取openId的响应：" + resp);

        return StringUtils.substringBetween(resp, "\"openid\":\"", "\"}");
    }

    /**
     * 获取AccessToken
     *
     * @param accessTokenUrl
     * @return
     */
    private QQAccessToken getQQAccessToken(String accessTokenUrl) {
        RestTemplate template = new RestTemplate();
        String resp = template.getForObject(accessTokenUrl, String.class);
        logger.info("获取accessToken的响应：" + resp);

        String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(resp, "&");
        String accessToken = StringUtils.substringAfterLast(items[0], "=");
        Integer expiresIn = Integer.valueOf(StringUtils.substringAfterLast(items[1], "="));
        String refreshToken = StringUtils.substringAfterLast(items[2], "=");

        return new QQAccessToken(accessToken, expiresIn, refreshToken);
    }
}
