package com.rappi.restaurants.core.countries.ports.gateway.web

import com.rappi.restaurants.core.countries.entities.Continent

interface ContinentsGatewayService {
    fun findAvailableContinents(): List<Continent>
}