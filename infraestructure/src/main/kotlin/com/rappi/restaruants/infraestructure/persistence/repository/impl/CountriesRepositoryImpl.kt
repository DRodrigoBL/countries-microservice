package com.rappi.restaurants.infraestructure.persistence.repository.impl

import com.rappi.restaurants.core.countries.entities.Country
import com.rappi.restaurants.infraestructure.persistence.entities.ContinentEnum
import com.rappi.restaurants.infraestructure.persistence.entities.CountryTable
import com.rappi.restaurants.infraestructure.persistence.entities.toCountryModel
import com.rappi.restaurants.infraestructure.persistence.repository.CountriesRepository
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.stereotype.Repository

@Repository
class CountriesRepositoryImpl(
        private val jdbcTemplate: JdbcTemplate) : CountriesRepository {

    override fun findCountriesByContinent(continent: String): List<CountryTable> {
        return try {
            jdbcTemplate.query(
                    QUERY_ALL_COUNTRIES_BY_CONTINENT,
                    arrayOf(continent),
                    ResultSetExtractor { resultSet ->
                        arrayListOf<CountryTable>().apply {
                            while (resultSet.next()) {
                                add(CountryTable.fromResultSet(resultSet))
                            }
                        }
                    })!!
        } catch (exc: EmptyResultDataAccessException) {
            return emptyList()
        }
    }

    companion object {
        private const val QUERY_ALL_COUNTRIES_BY_CONTINENT =
                "SELECT id, name, continent FROM countries WHERE continent = ?"
    }

}