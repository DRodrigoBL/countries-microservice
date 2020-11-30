package com.rappi.restaurants.infraestructure.configuration

import com.rappi.restaurants.core.countries.ports.ContinentsGatewayService
import com.rappi.restaurants.core.countries.ports.CountriesRepositoryService
import com.rappi.restaurants.core.countries.usecase.api.FindCountriesByContinentUseCase
import com.rappi.restaurants.core.countries.usecase.impl.FindCountriesByContinentUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WiringConfiguration {

    @Bean
    fun findCountriesByContinentUseCase(countriesRepositoryService: CountriesRepositoryService,
                                        continentsGatewayService: ContinentsGatewayService):
            FindCountriesByContinentUseCase {
        return FindCountriesByContinentUseCaseImpl(countriesRepositoryService, continentsGatewayService)
    }

}