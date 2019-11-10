package com.imooc.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @类名: DeferredResultHolder<br />
 * @包名：com.imooc.async<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/10 19:36<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
@Component
public class DeferredResultHolder {

    private Map<String, DeferredResult<String>> map = new HashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
