package com.imooc.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import com.imooc.security.app.social.AppSignUpUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名: UserController<br/>
 * 包名：com.imooc.controller<br/>
 * 作者：kevin<br/>
 * 时间：2019/8/27 11:05<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @Autowired
    private AppSignUpUtils appSignUpUtils;

    @PostMapping("/regist")
    public void regist(User user, HttpServletRequest request) {
        // 不管是注册用户还是绑定用户，都会拿到一个用户唯一标识，这里以用户名作为userId
        String userId = user.getUsername();
//        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
        appSignUpUtils.doPostSignUp(new ServletWebRequest(request), userId);
    }

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(UserQueryCondition condition,
                            @PageableDefault(size = 15, page = 3, sort = "username,asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder
                .toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam("用户id") @PathVariable String id) {
        System.out.println("进入getInfo服务");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user) {
        System.out.println(user);
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {
        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
                System.out.println(error.getDefaultMessage());
            });
        }
        System.out.println(user);
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }
}
