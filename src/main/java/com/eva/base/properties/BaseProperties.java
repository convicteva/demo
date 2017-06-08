package com.eva.base.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jamin on 2017/5/25.
 */
@Configuration
@ConfigurationProperties("base")
public class BaseProperties {

    private String noAuthUrlMatch;

    private String adminSessionKey;

    public String getAdminSessionKey() {
        return adminSessionKey;
    }

    public void setAdminSessionKey(String adminSessionKey) {
        this.adminSessionKey = adminSessionKey;
    }

    public String getNoAuthUrlMatch() {
        return noAuthUrlMatch;
    }

    public void setNoAuthUrlMatch(String noAuthUrlMatch) {
        this.noAuthUrlMatch = noAuthUrlMatch;
    }
}
