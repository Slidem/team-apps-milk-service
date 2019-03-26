package com.teamapps.milkservice.rest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Mihai Alexandru
 * @date 25.12.2018
 */
@Component
@ConfigurationProperties(prefix = "oauth")
public class OauthProperties {

    private String checkTokenUrl;

    private String clientId;

    private String clientSecret;

    private String scope;

    public String getCheckTokenUrl() {
        return checkTokenUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setCheckTokenUrl(String checkTokenUrl) {
        this.checkTokenUrl = checkTokenUrl;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
