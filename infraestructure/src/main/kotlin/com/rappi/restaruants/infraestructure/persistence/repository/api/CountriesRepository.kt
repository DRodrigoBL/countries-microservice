package com.rappi.restaruants.infraestructure.persistence.repository.api

import com.rappi.restaurants.infraestructure.persistence.entities.CountryTable

interface CountriesRepository {
    fun findCountriesByContinent(continent: String): List<CountryTable>
}