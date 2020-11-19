package com.countries.ports

import com.countries.entities.Country

interface CountriesRepositoryService {

    fun findCountriesByContinent(continent: String): List<Country>
}