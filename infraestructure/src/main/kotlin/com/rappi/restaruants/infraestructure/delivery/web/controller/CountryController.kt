package com.rappi.restaurants.infraestructure.delivery.web.controller

import com.rappi.restaurants.infraestructure.delivery.web.model.CountriesResponse
import com.rappi.restaurants.infraestructure.delivery.web.model.CountryResponse
import com.rappi.restaurants.infraestructure.gateway.web.continents.client.ContinentsApi
import com.rappi.restaurants.infraestructure.gateway.web.continents.model.ContinentsApiResponse
import com.rappi.restaurants.core.countries.usecase.api.FindCountriesByContinentUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/")
class CountryController(private val findCountriesByContinentUseCase: FindCountriesByContinentUseCase,
                        private val continentsApi: ContinentsApi) {

    @GetMapping("continent/{continentId}/countries")
    fun findCountriesByContinent(@PathVariable("continentId") continentId: String): ResponseEntity<CountriesResponse> {
        val continentCountries = findCountriesByContinentUseCase.execute(continentId)
        val toList = continentCountries.map { c -> CountryResponse(c.id, c.name) }.toList()
        return ResponseEntity.ok(CountriesResponse(continentId, toList))
    }



}