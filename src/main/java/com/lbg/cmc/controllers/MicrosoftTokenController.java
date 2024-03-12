package com.lbg.cmc.controllers;

import com.lbg.cmc.services.MicrosoftTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Azure Token API")
public class MicrosoftTokenController {

    @Autowired
    private MicrosoftTokenService microsoftTokenService;


    @ApiOperation(value = "Obtain JWT token from Azure Auth Provider", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully return Bearer Token"),
            @ApiResponse(code = 500, message = "Internal Service errors")
    }
    )
    @GetMapping("/token")
    public ResponseEntity<?> getMicrosoftToken() {
        return ResponseEntity.ok(microsoftTokenService.getAuthToken());
    }
}
