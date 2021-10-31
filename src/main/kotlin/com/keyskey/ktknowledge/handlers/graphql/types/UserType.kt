package com.keyskey.ktknowledge.handlers.graphql.types

import com.expediagroup.graphql.generator.scalars.ID
import com.keyskey.ktknowledge.repositories.database.UserRecord

data class UserType (val id: ID, val name: String)

fun UserRecord.toUserType(): UserType {
    if (id != null && name != null) {
        return UserType(
            id = ID(id.toString()),
            name = name
        )
    } else {
        throw IllegalStateException()
    }
}
