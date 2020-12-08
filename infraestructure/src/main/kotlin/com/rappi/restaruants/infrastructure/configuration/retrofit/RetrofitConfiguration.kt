package com.rappi.restaruants.infrastructure.configuration.retrofit

import com.fasterxml.jackson.databind.ObjectMapper
import com.rappi.restaruants.infrastructure.gateway.web.continents.client.ContinentsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

@Configuration
class RetrofitConfiguration(@Value("\${config.retrofit.baseURL}") private val baseUrl: String) {

    @Bean
    fun okHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC })
            .build()

    @Bean(name = ["retrofit"])
    fun retrofit(okHttpClient: OkHttpClient, objectMapper: ObjectMapper): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(JacksonConverterFactory.create(objectMapper))
        .client(okHttpClient)
        .build()

    @Bean
    fun continentsApi(retrofit: Retrofit): ContinentsApi {
        return retrofit.create(ContinentsApi::class.java)
    }
}

private const val DEFAULT_TIMEOUT = 5000L
