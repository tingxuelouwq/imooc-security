package com.imooc.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @类名: UserDetailService<br />
 * @包名：com.imooc.security.browser.service<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/13 18:47<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@Component
public class MyUserDetailService implements UserDetailsService, SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名: {}", username);
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("社交登录用户id: {}", userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {
        // 模拟调用DAO层接口根据用户名从数据中查找用户信息
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是:" + password);
        return new SocialUser(userId, password, true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
