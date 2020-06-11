package com.jfs.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig  
	extends WebMvcConfigurerAdapter {

		public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.jfs.user.controller";
	    public static final String VERSION = "1.0.0";
	    
		@Value("${swagger.enabled}")
	    public String swaggerEnabled;
	    

	    @Bean 
	    public Docket createRestApi() {
	    	Docket docket = new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
	                .paths(PathSelectors.any())
	                .build()
	                .enable(false);
	    	
	    	docket.enable(Boolean.valueOf(swaggerEnabled));    	
	    	return docket;
	    }
	    
	    
	    private ApiInfo apiInfo() {
	    	 
	        return new ApiInfoBuilder()
	                .title("User Swagger ")
	                .termsOfServiceUrl("http://127.0.0.1:8771/doc.html")
	                .version("1.0")
	                .description("TEST")
	                .build();
	    }
	    

}
