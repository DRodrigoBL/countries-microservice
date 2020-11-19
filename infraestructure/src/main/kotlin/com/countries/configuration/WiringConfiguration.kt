package com.countries.configuration

import com.countries.ports.ContinentsGatewayService
import com.countries.ports.CountriesRepositoryService
import com.countries.usecase.api.FindCountriesByContinentUseCase
import com.countries.usecase.impl.FindCountriesByContinentUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WiringConfiguration {

    @Bean
    fun findCountriesByContinentUseCase(countriesRepositoryService: CountriesRepositoryService,
                                        continentsGatewayService: ContinentsGatewayService):
            FindCountriesByContinentUseCase{
        return FindCountriesByContinentUseCaseImpl(countriesRepositoryService, continentsGatewayService)
    }

}