package com.countries.gateway.web.continents.client

import com.countries.gateway.web.continents.model.ContinentsApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ContinentsApi {

    @GET("/api/v1/continents")
    fun getAvailableContinents(): Single<ContinentsApiResponse>

}