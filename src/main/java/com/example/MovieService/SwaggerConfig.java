package com.example.MovieService;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI myOpenAPI(){
        Info info = new Info()
                .title("Movie service REST API")
                .version("1.0")
                .description("This API exposes endpoints to manage movie repository");
        return new OpenAPI().info(info);
    }
}
