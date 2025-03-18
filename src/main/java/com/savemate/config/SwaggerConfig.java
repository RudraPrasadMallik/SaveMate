package com.savemate.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

public class SwaggerConfig {
	
		
	public OpenAPI customOpenAPI() {
		 return new OpenAPI()
		            .info(new Info()
		                .title("SaveMate API")
		                .version("1.0")
		                .description("API documentation for SaveMate"))
		            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
		            .components(new io.swagger.v3.oas.models.Components()
		                .addSecuritySchemes("bearerAuth", new SecurityScheme()
		                    .name("bearerAuth")
		                    .type(SecurityScheme.Type.HTTP)
		                    .scheme("bearer")
		                    .bearerFormat("JWT")));
				
		
	}
	 

}
