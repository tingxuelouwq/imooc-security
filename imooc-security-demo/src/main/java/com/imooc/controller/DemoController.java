package com.imooc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名: DemoController<br/>
 * 包名：com.imooc.controller<br/>
 * 作者：kevin<br/>
 * 时间：2019/8/27 11:05<br/>
 * 版本：1.0<br/>
 * 描述：<br/>
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }
}
