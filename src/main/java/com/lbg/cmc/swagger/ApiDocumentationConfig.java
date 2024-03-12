package com.lbg.cmc.swagger;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                description = "Azure OAuth to Confluent Cloud",
                version = "V12.0.12",
                title = "CMC OAuth API",
                contact = @Contact(
                        name = "Ajay Kumar Gupta",
                        email = "ajay.kumar1@publicissapient.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"},
        schemes = {SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS}

)
public interface ApiDocumentationConfig {

}
