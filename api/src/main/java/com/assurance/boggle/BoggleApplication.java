package com.assurance.boggle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@ComponentScan(basePackages = {"com.assurance.boggle"})
@EnableSwagger2
public class BoggleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoggleApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.assurance.boggle.controller"))
                .paths(PathSelectors.any()).build().apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo("Assurance Boggle REST API", "Boggle game rest endpoints", "v1", "urn:tos",
                new Contact("Assurance", "https://www.assurance.com", "info@assurance.com"), "Public GNU",
                "", Collections.emptyList());
    }
}
