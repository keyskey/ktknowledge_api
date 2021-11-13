package com.keyskey.ktknowledge

import com.keyskey.ktknowledge.handlers.graphql.types.CustomSchemaGeneratorHooks
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class KtknowledgeApplication {
	@Bean
	fun customGraphQLSchemaGeneratorHooks() = CustomSchemaGeneratorHooks()
}

fun main(args: Array<String>) {
	runApplication<KtknowledgeApplication>(*args)
}
