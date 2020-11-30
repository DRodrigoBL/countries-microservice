package com.rappi.restaurants.infraestructure.persistence.repository

import com.rappi.restaurants.infraestructure.persistence.entities.ContinentEnum
import com.rappi.restaurants.infraestructure.persistence.entities.CountryTable

interface CountriesRepository {

    fun findCountriesByContinent(continent: String): List<CountryTable>

}