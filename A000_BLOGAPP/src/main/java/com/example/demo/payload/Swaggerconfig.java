package com.example.demo.payload;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class Swaggerconfig {
//	public Docket SwaggerApi() {
//	       return new Docket(DocumentationType.SWAGGER_2)
//	               .select()
//	               .apis(RequestHandlerSelectors.any())
//	               .paths(PathSelectors.any())
//	               .build();
//	}
	
	@Bean
	public OpenAPI apiInfo() {
		return new OpenAPI()
				.info(new Info()
				.title("Blog Application Api")
				.description("Spring Boot Blog App Using JWT And Role-based Auth")
				.version("v1.0")
				);
	}
}
