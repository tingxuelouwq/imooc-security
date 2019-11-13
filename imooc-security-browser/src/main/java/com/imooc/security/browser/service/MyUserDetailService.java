package com.imooc.security.browser.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class MyUserDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名: {}", username);
        // 模拟调用DAO层接口根据用户名从数据中查找用户信息
        String password = passwordEncoder.encode("123456");
        logger.info("数据库密码是:" + password);
        return new User(username, password,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
