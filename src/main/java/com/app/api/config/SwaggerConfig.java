package com.app.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private static final String BASIC_AUTH = "basicAuth";
	private static final String BEARER_AUTH = "Bearer";

	@SuppressWarnings("deprecation")
	@Bean
	public Docket swaggerConfiguration() {

		// Adding Header
		ParameterBuilder aParameterBuilder = new ParameterBuilder();
		aParameterBuilder.name("Authorization") // name of header
				.modelRef(new ModelRef("string")).parameterType("header") // type - header
				.defaultValue("Basic em9uZTpteXBhc3N3b3Jk") // based64 of - zone:mypassword
				.required(true) // for compulsory
				.build();
		java.util.List<Parameter> aParameters = new ArrayList<>();
		aParameters.add(aParameterBuilder.build());

		/*
		 * return new
		 * Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/**"))
		 * .apis(RequestHandlerSelectors.basePackage("com.app.api.controller")).build()
		 * .apiInfo(new ApiInfo("AppAPI", "Traking App", "version 1.0",
		 * "termsOfServiceUrl", "Kd & Anurag", "license", "licenseUrl"));
		 */
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(new ApiInfo("AppAPI", "Traking App", "version 1.0",
						"termsOfServiceUrl", "Kd & Anurag", "license", "licenseUrl"))
				.pathMapping("").globalOperationParameters(aParameters);
	}

	/*
	 * private List<SecurityScheme> securitySchemes() { return List.of(new
	 * BasicAuth(BASIC_AUTH), new ApiKey(BEARER_AUTH, "Authorization", "header")); }
	 * 
	 * private SecurityContext securityContext() { return
	 * SecurityContext.builder().securityReferences(List.of(basicAuthReference(),
	 * bearerAuthReference())) .forPaths(PathSelectors.ant("/products/**")).build();
	 * }
	 */
	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("AUTHORIZATION", authorizationScopes));
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/anyPath.*"))
				.build();
	}

	private SecurityReference basicAuthReference() {
		return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
	}

	private SecurityReference bearerAuthReference() {
		return new SecurityReference(BEARER_AUTH, new AuthorizationScope[0]);
	}
	// https://www.javachinna.com/2020/04/24/building-spring-boot-2-x-restful-crud-api-with-spring-data-jpa-hibernate-lombok-and-mysql-in-7-simple-steps/

}
