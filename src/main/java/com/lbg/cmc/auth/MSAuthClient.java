package com.lbg.cmc.auth;

import com.fasterxml.jackson.databind.JsonNode;
import com.lbg.cmc.config.MicrosoftAuthConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient(name = "microsoft.auth.service", url = "${microsoft.auth.url}",configuration = MicrosoftAuthConfig.class)
public interface MSAuthClient {

    @RequestMapping(method = RequestMethod.POST, value = "/oauth2/v2.0/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    JsonNode getAuthToken(Map<String, ?> queryMap);
}
