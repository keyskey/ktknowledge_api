package com.keyskey.ktknowledge.handlers.graphql.types

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.handlers.graphql.utils.toID
import java.time.LocalDateTime

const val userTypeGraphQLName = "User"

@GraphQLName(userTypeGraphQLName)
data class UserType (val id: ID, val name: String, val createdAt: LocalDateTime, val updatedAt: LocalDateTime)

fun User.toUserType(): UserType = UserType(
    id = id.toID(userTypeGraphQLName),
    name = name,
    createdAt = createdAt,
    updatedAt = updatedAt
)
