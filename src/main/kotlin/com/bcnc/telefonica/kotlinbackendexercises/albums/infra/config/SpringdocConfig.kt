package com.bcnc.telefonica.kotlinbackendexercises.albums.infra.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@OpenAPIDefinition
@Configuration
class SpringdocConfig {

    @Bean
    fun springdocOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                io.swagger.v3.oas.models.info.Info()
                    .title("Albums API")
                    .description("Albums API")
                    .version("v0.0.1")
            )
    }
}