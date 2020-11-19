package com.countries.gateway.web.continents.service

import com.countries.entities.Continent
import com.countries.gateway.web.continents.client.ContinentsApi
import com.countries.ports.ContinentsGatewayService
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class ContinentsGatewayServiceImpl(
        val continentsApi: ContinentsApi
        ): ContinentsGatewayService {

    override fun findAvailableContinents(): List<Continent> {
        val continents = continentsApi.getAvailableContinents().blockingGet()
        return continents.availableContinents.stream().map { c -> Continent(c) }.toList()
    }
}