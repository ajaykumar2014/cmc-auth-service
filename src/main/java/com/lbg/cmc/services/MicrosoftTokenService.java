package com.lbg.cmc.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.lbg.cmc.auth.MSAuthClient;
import com.lbg.cmc.config.PropertyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MicrosoftTokenService {

    @Autowired
    private PropertyConfig propertyConfig;
    @Autowired
    protected MSAuthClient msAuthClient;

    public JsonNode getAuthToken() {
        Map<String, String> authRequest = new HashMap<>();
        authRequest.put("client_id", propertyConfig.getClientId());
        authRequest.put("client_secret", propertyConfig.getClientSecret());
        authRequest.put("scope", propertyConfig.getScope());
        authRequest.put("grant_type", propertyConfig.getGrantType());
        try {
            return msAuthClient.getAuthToken(authRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    public String getToken() {
        return getAuthToken().get("access_token").asText();
    }


}
