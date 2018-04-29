package com.surgeon.eye.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket  sharpSightApiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.or(PathSelectors.regex("/user.*"),
						PathSelectors.regex("/doctor.*"),
						PathSelectors.regex("/patient.*"),
						PathSelectors.regex("/pharmacist.*"),
						PathSelectors.regex("/admin.*")))
						.build();
		
		
	}

}
