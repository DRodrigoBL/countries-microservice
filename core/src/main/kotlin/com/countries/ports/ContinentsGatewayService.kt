package com.countries.ports

import com.countries.entities.Continent

interface ContinentsGatewayService {

    fun findAvailableContinents(): List<Continent>

}