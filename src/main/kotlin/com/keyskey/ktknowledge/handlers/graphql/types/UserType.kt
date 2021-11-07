package com.keyskey.ktknowledge.handlers.graphql.types

import com.expediagroup.graphql.generator.scalars.ID
import com.keyskey.ktknowledge.entities.User

data class UserType (val id: ID, val name: String)

fun User.toUserType(): UserType = UserType(
    id = ID(id.toString()),
    name = name
)
