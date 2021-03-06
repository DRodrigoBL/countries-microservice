package com.rappi.restaurants.core.countries.ports.persistence

import com.rappi.restaurants.core.countries.entities.Country

interface CountriesRepositoryService {
    fun findCountriesByContinent(continent: String): List<Country>
    fun createCountry(country: Country, continent: String)
}