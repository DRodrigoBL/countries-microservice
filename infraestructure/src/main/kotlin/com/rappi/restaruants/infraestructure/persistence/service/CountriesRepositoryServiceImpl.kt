package com.rappi.restaurants.infraestructure.persistence.service

import com.rappi.restaurants.core.countries.entities.Country
import com.rappi.restaurants.infraestructure.persistence.entities.toCountryModel
import com.rappi.restaruants.infraestructure.persistence.repository.api.CountriesRepository
import com.rappi.restaurants.core.countries.ports.persistence.CountriesRepositoryService
import org.springframework.stereotype.Service

@Service
class CountriesRepositoryServiceImpl(
        private val countryRepository: CountriesRepository
        ): CountriesRepositoryService {

    override fun findCountriesByContinent(continent: String): List<Country> {
        val countriesByContinent = countryRepository.findCountriesByContinent(continent)
        return countriesByContinent.map { c -> c.toCountryModel() }
    }
}