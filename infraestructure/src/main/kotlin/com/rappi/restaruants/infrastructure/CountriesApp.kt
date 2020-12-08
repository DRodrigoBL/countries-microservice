package com.rappi.restaruants.infrastructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CountriesApp

fun main(args: Array<String>) {
    @Suppress("SpreadOperator")
    runApplication<CountriesApp>(*args)
}
