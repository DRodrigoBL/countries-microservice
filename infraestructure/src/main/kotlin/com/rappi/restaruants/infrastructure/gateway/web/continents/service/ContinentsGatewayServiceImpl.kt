package com.rappi.restaurants.infraestructure.gateway.web.continents.service

import com.rappi.restaurants.core.countries.entities.Continent
import com.rappi.restaurants.core.countries.exception.ContinentUnavailableException
import com.rappi.restaurants.infraestructure.gateway.web.continents.client.ContinentsApi
import com.rappi.restaurants.core.countries.ports.gateway.web.ContinentsGatewayService
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class ContinentsGatewayServiceImpl(
        val continentsApi: ContinentsApi
        ): ContinentsGatewayService {

    override fun findAvailableContinents(): List<Continent> {
        val continents = continentsApi.getAvailableContinents().execute().body()
                ?: throw ContinentUnavailableException()
        return continents.availableContinents.stream().map { c -> Continent(c) }.toList()
    }
}