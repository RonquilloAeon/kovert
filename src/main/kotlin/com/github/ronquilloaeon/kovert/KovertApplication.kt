package com.github.ronquilloaeon.kovert

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KovertApplication

fun main(args: Array<String>) {
	runApplication<KovertApplication>(*args)
}
