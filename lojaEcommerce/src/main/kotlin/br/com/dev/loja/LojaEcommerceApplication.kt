package br.com.dev.loja

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class LojaEcommerceApplication

fun main(args: Array<String>) {
	runApplication<LojaEcommerceApplication>(*args)


}


