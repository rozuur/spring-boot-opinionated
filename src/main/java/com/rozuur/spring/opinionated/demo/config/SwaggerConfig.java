package com.rozuur.spring.opinionated.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${application.name}")
    private String title;

    @Value("${application.description}")
    private String description;

    @Value("${application.swagger.name}")
    private String name;

    @Value("${application.swagger.url}")
    private String url;

    @Value("${application.swagger.email}")
    private String email;

    @Value("${application.swagger.license}")
    private String license;

    @Value("${application.swagger.license.url}")
    private String licenseUrl;

    @Bean
    public Docket api() {
        String parentPackage = SwaggerConfig.class.getPackageName().replace(".config", "");
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(parentPackage))
                .build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title(title).description(description)
                .contact(new Contact(name, url, email))
                .license(license).licenseUrl(licenseUrl).build();
    }
}
