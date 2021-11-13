package com.keyskey.ktknowledge.handlers.graphql.types

import com.expediagroup.graphql.generator.scalars.ID
import com.keyskey.ktknowledge.entities.User
import java.time.LocalDateTime

data class UserType (val id: ID, val name: String, val createdAt: LocalDateTime, val updatedAt: LocalDateTime)

fun User.toUserType(): UserType = UserType(
    id = ID(id.toString()),
    name = name,
    createdAt = createdAt,
    updatedAt = updatedAt
)
