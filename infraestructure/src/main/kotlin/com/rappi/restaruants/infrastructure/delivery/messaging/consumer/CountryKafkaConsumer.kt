package com.rappi.restaruants.infrastructure.delivery.messaging.consumer

import com.rappi.restaruants.infrastructure.delivery.messaging.model.CountryMessage
import com.rappi.restaurants.core.countries.entities.Continent
import com.rappi.restaurants.core.countries.entities.Country
import com.rappi.restaurants.core.countries.usecase.api.RegisterNewCountryUseCase
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
internal class CountryKafkaConsumer(
        private val registerNewCountryUseCase: RegisterNewCountryUseCase
) {

    @KafkaListener(topics = ["country_new"], groupId = "country_new",
            containerFactory = "countryKafkaListenerFactory" )
    fun listener(countryMessage: CountryMessage) {
        registerNewCountryUseCase.registerNewCountry(
                Country(0, countryMessage.countryName),
                Continent(countryMessage.continentName))
    }

}