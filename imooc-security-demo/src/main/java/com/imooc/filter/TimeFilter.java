package com.imooc.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @类名: TimeFilter<br />
 * @包名：com.imooc.filter<br/>
 * @作者：kevin<br/>
 * @时间：2019/9/10 22:54<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
//@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("time filter start");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        System.out.println("time filter 耗时:"+ (System.currentTimeMillis() - start));
        System.out.println("time filter finish");
    }

    @Override
    public void destroy() {
        System.out.println("time filter destroy");
    }
}
