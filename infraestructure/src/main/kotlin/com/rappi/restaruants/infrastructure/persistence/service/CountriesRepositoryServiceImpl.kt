package com.rappi.restaruants.infrastructure.persistence.service

import com.rappi.restaruants.infrastructure.persistence.entities.ContinentEnum
import com.rappi.restaruants.infrastructure.persistence.entities.CountryTable
import com.rappi.restaruants.infrastructure.persistence.entities.toCountryModel
import com.rappi.restaruants.infrastructure.persistence.repository.api.CountriesRepository
import com.rappi.restaurants.core.countries.entities.Country
import com.rappi.restaurants.core.countries.exception.CountryNotCreatedException
import com.rappi.restaurants.core.countries.ports.persistence.CountriesRepositoryService
import org.springframework.stereotype.Service

@Service
class CountriesRepositoryServiceImpl(
    private val countryRepository: CountriesRepository
) : CountriesRepositoryService {

    override fun findCountriesByContinent(continent: String): List<Country> {
        val countriesByContinent = countryRepository.findCountriesByContinent(continent)
        return countriesByContinent.map { c -> c.toCountryModel() }
    }

    override fun createCountry(country: Country, continent: String) {
        val created = countryRepository
            .createCountry(CountryTable(0, country.name, ContinentEnum.valueOf(continent)))
        if (created != 1) {
            throw CountryNotCreatedException()
        }
    }
}
