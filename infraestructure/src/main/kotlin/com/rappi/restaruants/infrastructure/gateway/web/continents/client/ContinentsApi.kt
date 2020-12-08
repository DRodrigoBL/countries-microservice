package com.rappi.restaruants.infrastructure.gateway.web.continents.client

import com.rappi.restaruants.infrastructure.gateway.web.continents.model.ContinentsApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ContinentsApi {
    @GET("/api/v1/continents")
    fun getAvailableContinents(): Call<ContinentsApiResponse>
}
