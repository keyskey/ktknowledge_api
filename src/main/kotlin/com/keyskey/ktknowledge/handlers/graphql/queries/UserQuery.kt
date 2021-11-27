package com.keyskey.ktknowledge.handlers.graphql.queries

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toInt
import com.keyskey.ktknowledge.repositories.UserRepository
import org.springframework.stereotype.Component

@Component
class UserQuery(private val userRepository: UserRepository): Query {
    fun users(): List<UserType> {
        return userRepository
            .findAll()
            .map { it.toUserType() }
    }

    fun user(id: ID): UserType? {
        val intId = id.toInt()

        return userRepository
            .findById(intId)
            ?.toUserType()
    }
}
