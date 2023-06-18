package com.czp.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){   // 当前环境
        Profiles profiles = Profiles.of("test");  // 目标环境
        boolean flag = environment.acceptsProfiles(profiles);  // 当前环境是否可接纳目标环境

        return new Docket(DocumentationType.SWAGGER_2)
                // 为Docket设置信息
                .apiInfo(apiInfo())
                .enable(flag)                                // 若不可接纳,则关闭swagger
                // ======= 转化为ApiSelectorBuilder才可以设置扫描 ==========
                .select()
                // 指定扫描的包, 包下的API将被写成文档
                .apis(RequestHandlerSelectors.basePackage("com.czp.swagger.controller"))
                // [可选][过滤器] 过滤出指定路径的API, **表示任意文件
                .paths(PathSelectors.ant("/controller/**"))
                // ========== 再转化为Docket返回 =========================
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "兆鹏的 Swagger API文档",
                "个人demo",
                "1.0 xxx",
                "https://mvnrepository.com/artifact/io.springfox/springfox-swagger2/2.10.5",
                DEFAULT_CONTACT,
                "Apache 2.0 xxx",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }

}
