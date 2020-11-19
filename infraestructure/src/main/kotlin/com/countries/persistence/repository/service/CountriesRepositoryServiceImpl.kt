package com.countries.persistence.repository.service

import com.countries.entities.Country
import com.countries.persistence.entities.ContinentEnum
import com.countries.persistence.entities.CountryTable
import com.countries.persistence.entities.toCountryModel
import com.countries.persistence.repository.CountriesRepository
import com.countries.ports.CountriesRepositoryService
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
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