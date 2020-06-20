package com.imooc.security.core.properties;

/**
 * @类名: SecurityConstants<br />
 * @包名：com.imooc.security.core.properties<br/>
 * @作者：kevin<br/>
 * @时间：2020/5/23 14:32<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class SecurityConstants {

    /**
     * 默认的处理验证码的url前缀
     */
    public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
    /**
     * 当请求需要身份认证时，默认跳转的url
     */
    public static final String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
    /**
     * 默认的用户名密码登录请求处理url
     */
    public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/authentication/form";
    /**
     * 默认的手机验证码登录请求处理url
     */
    public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/authentication/mobile";
    /**
     * 默认的登录页面
     */
    public static final String DEFAULT_LOGIN_PAGE_URL = "/imooc-signIn.html";
    /**
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 发送短信验证码或验证短信验证码时，传递手机号的参数的名称
     */
    public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
    /**
     * 验证码生成器后缀名
     */
    public static final String DEFAULT_CODE_GENERATOR_SUFFIX = "CodeGenerator";
    /**
     * 验证码处理器后缀名
     */
    public static final String DEFAULT_CODE_PROCESSOR_SUFFIX = "CodeProcessor";
    /**
     * 默认的注册页面
     */
    public static final String DEFAULT_SIGNUP_PAGE_URL = "/imooc-signUp.html";
    /**
     * session默认的最大并发数
     */
    public static final int DEFAULT_MAXIMUM_SESSIONS = 1;
    /**
     * session失效默认的跳转地址
     */
    public static final String DEFAULT_SESSION_INVALID_URL = "/imooc-session-invalid.html";
}
