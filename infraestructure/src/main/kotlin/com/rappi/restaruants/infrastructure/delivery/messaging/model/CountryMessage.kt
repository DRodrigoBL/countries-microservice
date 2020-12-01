package com.rappi.restaruants.infrastructure.gateway.messaging.model

data class CountryMessage(val countryName: String,
                          val continentName: String,
                          val eventOrigin: String)