package com.keyskey.ktknowledge.handlers.graphql.types

import com.expediagroup.graphql.generator.hooks.SchemaGeneratorHooks
import graphql.scalars.ExtendedScalars
import graphql.schema.GraphQLType
import java.time.ZonedDateTime
import kotlin.reflect.KClass
import kotlin.reflect.KType

// see: https://github.com/ExpediaGroup/graphql-kotlin/blob/master/examples/server/spring-server/src/main/kotlin/com/expediagroup/graphql/examples/server/spring/hooks/CustomSchemaGeneratorHooks.kt
class CustomSchemaGeneratorHooks : SchemaGeneratorHooks {
    // Register additional GraphQL scalar types.
    override fun willGenerateGraphQLType(type: KType): GraphQLType? = when (type.classifier as? KClass<*>) {
        // see: https://github.com/graphql-java/graphql-java-extended-scalars/blob/master/src/main/java/graphql/scalars/ExtendedScalars.java
        ZonedDateTime::class -> ExtendedScalars.DateTime
        else -> null
    }
}
