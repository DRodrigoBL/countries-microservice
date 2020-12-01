package com.rappi.restaurants.core.countries.usecase.impl

import com.rappi.restaurants.core.countries.entities.Continent
import com.rappi.restaurants.core.countries.entities.Country
import com.rappi.restaurants.core.countries.ports.persistence.CountriesRepositoryService
import com.rappi.restaurants.core.countries.usecase.api.RegisterNewCountryUseCase

class RegisterNewCountryUseCaseImpl(private val countriesRepositoryService: CountriesRepositoryService):
        RegisterNewCountryUseCase {

    override fun registerNewCountry(country: Country, continent: Continent) {
        countriesRepositoryService.createCountry(country, continent.name)
    }
}