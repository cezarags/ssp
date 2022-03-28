package br.com.dev.loja.config

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class Config {

    @Bean
    fun configurer(
        @Value("\${spring.application.name}") applicationName: String?
    ): MeterRegistryCustomizer<MeterRegistry>? {
        return MeterRegistryCustomizer { registry: MeterRegistry ->
            registry.config().commonTags("application", applicationName)

            println(applicationName)
        }
    }


}