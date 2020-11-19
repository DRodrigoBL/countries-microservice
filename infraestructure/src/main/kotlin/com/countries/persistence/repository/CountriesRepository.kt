package com.countries.persistence.repository

import com.countries.persistence.entities.ContinentEnum
import com.countries.persistence.entities.CountryTable

interface CountriesRepository {

    fun findCountriesByContinent(continent: String): List<CountryTable>

}