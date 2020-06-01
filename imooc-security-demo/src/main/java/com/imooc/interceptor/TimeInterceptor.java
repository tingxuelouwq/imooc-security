package com.imooc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类名: TimeInterceptor<br/>
 * 包名：com.imooc.interceptor<br/>
 * 作者：kevin<br/>
 * 时间：2019/9/16 18:59<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("preHandler");
        System.out.println(((HandlerMethod) handler).getBean().getClass().getName());
        System.out.println(((HandlerMethod) handler).getMethod().getName());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            ModelAndView modelAndView) throws Exception {
        System.out.println("postHandler");
        long start = (long) request.getAttribute("startTime");
        System.out.println("time interceptor耗时: " + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("afterCompletion");
        long start = (long) request.getAttribute("startTime");
        System.out.println("time interceptor耗时: " + (System.currentTimeMillis() - start));
        System.out.println("ex is " + ex);
    }
}
