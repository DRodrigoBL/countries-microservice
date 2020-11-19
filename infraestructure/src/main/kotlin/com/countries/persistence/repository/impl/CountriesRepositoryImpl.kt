package com.countries.persistence.repository.impl

import com.countries.entities.Country
import com.countries.persistence.entities.ContinentEnum
import com.countries.persistence.entities.CountryTable
import com.countries.persistence.entities.toCountryModel
import com.countries.persistence.repository.CountriesRepository
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