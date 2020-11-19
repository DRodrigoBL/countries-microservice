package com.countries.persistence.service

import com.countries.entities.Country
import com.countries.persistence.entities.toCountryModel
import com.countries.persistence.repository.CountriesRepository
import com.countries.ports.CountriesRepositoryService
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