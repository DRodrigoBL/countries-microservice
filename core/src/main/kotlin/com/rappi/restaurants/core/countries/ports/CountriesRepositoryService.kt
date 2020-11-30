package com.rappi.restaurants.core.countries.ports

import com.rappi.restaurants.core.countries.entities.Country

interface CountriesRepositoryService {

    fun findCountriesByContinent(continent: String): List<Country>
}