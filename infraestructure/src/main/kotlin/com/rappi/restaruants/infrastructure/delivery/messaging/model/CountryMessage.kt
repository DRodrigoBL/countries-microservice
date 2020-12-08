package com.rappi.restaruants.infrastructure.delivery.messaging.model

data class CountryMessage(
    val countryName: String,
    val continentName: String,
    val eventOrigin: String
)
