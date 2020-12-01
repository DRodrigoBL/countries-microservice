package com.rappi.restaruants.infrastructure.configuration.kafka

import com.rappi.restaruants.infrastructure.delivery.messaging.model.CountryMessage
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer
import java.util.*


@EnableKafka
@Configuration
class KafkaConfiguration {

    @Value("\${config.kafka.server}")
    private lateinit var bootstrapServer: String

    @Bean
    fun countryMessageConsumerFactory(): ConsumerFactory<String, CountryMessage> {
        val config: MutableMap<String, Any> = HashMap()
        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServer
        config[ConsumerConfig.GROUP_ID_CONFIG] = "group_json"
        config[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "earliest"
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        return DefaultKafkaConsumerFactory<String, CountryMessage>(config, StringDeserializer(),
                JsonDeserializer(CountryMessage::class.java))
    }

    @Bean
    fun countryKafkaListenerFactory(): ConcurrentKafkaListenerContainerFactory<String, CountryMessage> {
        val factory: ConcurrentKafkaListenerContainerFactory<String, CountryMessage> =
                ConcurrentKafkaListenerContainerFactory<String, CountryMessage>()
        factory.consumerFactory = countryMessageConsumerFactory()
        return factory
    }
}