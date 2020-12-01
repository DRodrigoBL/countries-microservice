package com.rappi.restaurants.infraestructure.persistence.repository.impl

import com.rappi.restaruants.infrastructure.persistence.repository.api.CountriesRepository
import com.rappi.restaurants.core.countries.exception.CountryNotCreatedException
import com.rappi.restaurants.infraestructure.persistence.entities.CountryTable
import org.springframework.dao.DataAccessException
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

    override fun createCountry(country: CountryTable): Int {
        return try {
            jdbcTemplate.update(INSERT_COUNTRY, country.name, country.continent.name)
        } catch (exc: DataAccessException){
            exc.printStackTrace()
            throw CountryNotCreatedException()
        }
    }

    companion object {
        private const val QUERY_ALL_COUNTRIES_BY_CONTINENT =
                "SELECT id, name, continent FROM countries WHERE continent = ?"
        private const val INSERT_COUNTRY =
                "INSERT INTO countries (name, continent) VALUES (?, ?)"
    }

}