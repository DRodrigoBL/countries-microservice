package com.countries.usecase.api

import com.countries.entities.Country

interface FindCountriesByContinentUseCase {

    fun execute(continent: String): List<Country>

}