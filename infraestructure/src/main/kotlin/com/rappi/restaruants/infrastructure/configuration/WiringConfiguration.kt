package com.rappi.restaruants.infrastructure.configuration

import com.rappi.restaurants.core.countries.ports.gateway.web.ContinentsGatewayService
import com.rappi.restaurants.core.countries.ports.persistence.CountriesRepositoryService
import com.rappi.restaurants.core.countries.usecase.api.FindCountriesByContinentUseCase
import com.rappi.restaurants.core.countries.usecase.api.RegisterNewCountryUseCase
import com.rappi.restaurants.core.countries.usecase.impl.FindCountriesByContinentUseCaseImpl
import com.rappi.restaurants.core.countries.usecase.impl.RegisterNewCountryUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WiringConfiguration {

    @Bean
    fun findCountriesByContinentUseCase(
        countriesRepositoryService: CountriesRepositoryService,
        continentsGatewayService: ContinentsGatewayService
    ):
        FindCountriesByContinentUseCase {
            return FindCountriesByContinentUseCaseImpl(countriesRepositoryService, continentsGatewayService)
        }

    @Bean
    fun registerNewCountryUseCase(countriesRepositoryService: CountriesRepositoryService):
        RegisterNewCountryUseCase {
            return RegisterNewCountryUseCaseImpl(countriesRepositoryService)
        }
}
