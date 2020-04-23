package no.bouvet.paas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaasApplication

fun main(args: Array<String>) {
	runApplication<PaasApplication>(*args)
}
