package com.rappi.restaruants.infrastructure.gateway.messaging.consumer

import com.rappi.restaruants.infrastructure.gateway.messaging.model.CountryMessage
import com.rappi.restaruants.infrastructure.gateway.messaging.service.CountryConsumerService
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
internal class CountryKafkaConsumer(
        private val countryConsumerService: CountryConsumerService
) {

    @KafkaListener(topics = ["country_new"], groupId = "country_new",
            containerFactory = "countryKafkaListenerFactory" )
    fun listener(countryMessage: CountryMessage) {
        countryConsumerService.registerCountry(countryMessage)
    }

}