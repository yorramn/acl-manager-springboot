package com.yorramn.gerenciaacl.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.HashSet;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    private Contact contact() {
        return new Contact(
            "Gabriel Yorramn",
            "https://github.com/yorramn",
            "yorramn.dev@gmail.com"
        );
    }

    private ApiInfoBuilder apiInfoBuilder() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Api gerenciadora de ACL");
        apiInfoBuilder.description("Gerenciamento de ACL de usuário e permissões");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Open Source");
        apiInfoBuilder.license("Licença");
        apiInfoBuilder.licenseUrl("https://github.com/yorramn");
        apiInfoBuilder.contact(this.contact());
        return apiInfoBuilder;
    }

    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.select()
                .apis(RequestHandlerSelectors.basePackage("com.yorramn.gerenciaacl.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.apiInfoBuilder().build())
                .consumes(new HashSet<String>(List.of("application/json")))
                .produces(new HashSet<String>(List.of("application/json")));
        return docket;
    }
}
