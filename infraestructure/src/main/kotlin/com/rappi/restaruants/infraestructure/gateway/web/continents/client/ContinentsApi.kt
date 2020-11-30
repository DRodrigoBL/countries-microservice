package com.rappi.restaurants.infraestructure.gateway.web.continents.client

import com.rappi.restaurants.infraestructure.gateway.web.continents.model.ContinentsApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ContinentsApi {

    @GET("/api/v1/continents")
    fun getAvailableContinents(): Single<ContinentsApiResponse>

}