package com.keyskey.ktknowledge.handlers.graphql.types

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.handlers.graphql.utils.toID
import java.time.ZoneId
import java.time.ZonedDateTime

const val userTypeGraphQLName = "User"

@GraphQLName(userTypeGraphQLName)
data class UserType(
    val id: ID,
    val name: String,
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime)
{
    constructor(user: User) : this(
        user.id.toID(userTypeGraphQLName),
        user.name,
        ZonedDateTime.of(user.createdAt, ZoneId.systemDefault()),
        ZonedDateTime.of(user.updatedAt, ZoneId.systemDefault())
    )
}
