package com.rappi.restaurants.core.countries.usecase.impl

import com.rappi.restaurants.core.countries.entities.Country
import com.rappi.restaurants.core.countries.ports.gateway.ContinentsGatewayService
import com.rappi.restaurants.core.countries.ports.persistence.CountriesRepositoryService
import com.rappi.restaurants.core.countries.usecase.api.FindCountriesByContinentUseCase

class FindCountriesByContinentUseCaseImpl(
        private val countriesRepositoryService: CountriesRepositoryService,
        private val continentsGatewayService: ContinentsGatewayService
) : FindCountriesByContinentUseCase {

    override fun execute(continent: String): List<Country> {

        //val availableContinents = continentsGatewayService.findAvailableContinents()
        /*if(!availableContinents.contains(Continent(continent))) {
            throw ContinentUnavailableException()
        }*/

        return countriesRepositoryService.findCountriesByContinent(continent)
    }

}