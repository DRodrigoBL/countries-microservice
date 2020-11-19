package com.countries.usecase.impl

import com.countries.entities.Continent
import com.countries.entities.Country
import com.countries.exception.ContinentUnavailableException
import com.countries.ports.ContinentsGatewayService
import com.countries.ports.CountriesRepositoryService
import com.countries.usecase.api.FindCountriesByContinentUseCase

class FindCountriesByContinentUseCaseImpl(
        private val countriesRepositoryService: CountriesRepositoryService,
        private val continentsGatewayService: ContinentsGatewayService
) : FindCountriesByContinentUseCase {

    override fun execute(continent: String): List<Country> {

        val availableContinents = continentsGatewayService.findAvailableContinents()
        if(!availableContinents.contains(Continent(continent))) {
            throw ContinentUnavailableException()
        }

        return countriesRepositoryService.findCountriesByContinent(continent)
    }
    
}