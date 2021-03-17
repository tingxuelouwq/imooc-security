package com.imooc.security.core.properties;

/**
 * kevin<br/>
 * 2021/3/17 10:34<br/>
 */
public class OAuth2Properties {

    private String jwtSigningKey = "imooc";

    private OAuth2ClientProperties[] clients = {};

    public String getJwtSigningKey() {
        return jwtSigningKey;
    }

    public void setJwtSigningKey(String jwtSigningKey) {
        this.jwtSigningKey = jwtSigningKey;
    }

    public OAuth2ClientProperties[] getClients() {
        return clients;
    }

    public void setClients(OAuth2ClientProperties[] clients) {
        this.clients = clients;
    }
}
