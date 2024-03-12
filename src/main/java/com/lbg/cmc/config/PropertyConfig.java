package com.lbg.cmc.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


//@ConfigurationProperties(prefix = "microsoft.auth")

@Configuration
public class PropertyConfig {

    @Value("${microsoft.auth.clientId}")
    private String clientId;

    @Value("${microsoft.auth.clientSecret}")
    private String clientSecret;

    @Value("${microsoft.auth.tenantID}")
    private String tenantId;

    @Value("${microsoft.auth.scope}")
    private String scope;

    @Value("${microsoft.auth.grant_type}")
    private String grantType;

    @Value("${confluent.clusterId}")
    private String clusterId;

    @Value("${confluent.identityPool}")
    private String identityPool;

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getIdentityPool() {
        return identityPool;
    }

    public void setIdentityPool(String identityPool) {
        this.identityPool = identityPool;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }


    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
}
