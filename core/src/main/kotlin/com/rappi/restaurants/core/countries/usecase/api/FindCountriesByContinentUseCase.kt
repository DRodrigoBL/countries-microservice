package com.rappi.restaurants.core.countries.usecase.api

import com.rappi.restaurants.core.countries.entities.Country

interface FindCountriesByContinentUseCase {

    fun execute(continent: String): List<Country>

}