package com.rappi.restaurants.infraestructure

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CountriesApp

fun main(args: Array<String>) {
	runApplication<CountriesApp>(*args)
}
