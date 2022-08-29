package org.javaboy.vhr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
@EnableWebMvc
public class SwaggerUIConfig {

    private static final boolean enable = true;
    private static final String title = "微人事后台接口文档";
    private static final String desc = "微人事是一个前后端分离的人力资源管理系统，项目采用SpringBoot+Vue开发。";
    private static final String version = "1.0.0";
    private static final String name = "Lenve";
    private static final String url = "https://github.com/lenve/vhr";
    private static final String email = "";

    @Bean
    public Docket createRestfulApi() {
        return new Docket(DocumentationType.OAS_30)
                .enable(enable)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/error").negate())  // 去掉 basic-error-controller 显示
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .contact(new Contact(name, url, email))
                .version(version)
                .description(desc)
                .build();
    }

}