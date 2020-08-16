package com.imooc.security.core.support;

/**
 * @类名: SimpleResponse<br />
 * @包名：com.imooc.security.browser.support<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/18 20:35<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class SimpleResponse {

    public SimpleResponse(Object content) {
        this.content = content;
    }

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
