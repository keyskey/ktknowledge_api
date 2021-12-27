package com.keyskey.ktknowledge.handlers.graphql.types

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.handlers.graphql.utils.toID
import java.time.LocalDateTime

const val userTypeGraphQLName = "User"

@GraphQLName(userTypeGraphQLName)
data class UserType(
    val id: ID,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime)
{
    constructor(user: User) : this(
        user.id.toID(userTypeGraphQLName),
        user.name,
        user.createdAt,
        user.updatedAt
    )
}
