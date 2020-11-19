package com.countries.delivery.web.model

import com.countries.entities.Country

data class CountriesResponse (val continent: String, val countries: List<CountryResponse>)

data class CountryResponse(val id: Long, val name: String)

fun CountryResponse.fromCountry(country: Country): CountryResponse = CountryResponse(country.id, country.name)