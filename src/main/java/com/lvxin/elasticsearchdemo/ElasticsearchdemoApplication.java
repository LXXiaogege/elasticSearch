package com.lvxin.elasticsearchdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//要添加Servlet支持
@SpringBootApplication
public class ElasticsearchdemoApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
//        return springApplicationBuilder.sources(ElasticsearchdemoApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchdemoApplication.class, args);
    }
}
