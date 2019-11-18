package com.imooc.security.core.properties;

/**
 * @类名: BrowserProperties<br />
 * @包名：com.imooc.security.core.properties<br/>
 * @作者：kevin<br/>
 * @时间：2019/11/18 20:44<br/>
 * @版本：1.0<br/>
 * @描述：<br/>
 */
public class BrowserProperties {

    private String loginPage = "/imooc-signIn.html";

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }
}
