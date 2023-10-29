package com.bcnc.telefonica.kotlinbackendexercises.albums.infra.config

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ModelMapperConfig {

    @Bean
    fun modelMapper(): ModelMapper {
        val modelMapper = ModelMapper()
        // Optional: Configure the model mapper as per your needs
        modelMapper.configuration.matchingStrategy = MatchingStrategies.LOOSE
        return modelMapper
    }
}