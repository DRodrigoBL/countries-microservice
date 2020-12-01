package com.rappi.restaurants.core.countries.usecase.api

import com.rappi.restaurants.core.countries.entities.Continent
import com.rappi.restaurants.core.countries.entities.Country

interface RegisterNewCountryUseCase {
    fun registerNewCountry(country: Country, continent: Continent)
}