package com.countries.persistence.entities

import com.countries.entities.Country
import java.sql.ResultSet

data class CountryTable(
        val id: Long,
        val name: String,
        val continent: ContinentEnum) {

    companion object{
        fun fromResultSet(rs: ResultSet) =
                CountryTable(
                        rs.getLong("id"),
                        rs.getString("name"),
                        ContinentEnum.valueOf(rs.getString("continent")))
    }

}

fun CountryTable.toCountryModel():Country = Country(id , name)