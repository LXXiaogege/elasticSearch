package com.lvxin.elasticsearchdemo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lvixn
 * @date 2018/11/18 11:00
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket CreateRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lvxin.elasticsearchdemo.Controller"))//扫描指定包
                .paths(PathSelectors.any())
                .build();
    }
    //配置基本信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger构建api文档")
                .description("Swagger初体验")
                .version("1.0")
                .build();
    }
}
