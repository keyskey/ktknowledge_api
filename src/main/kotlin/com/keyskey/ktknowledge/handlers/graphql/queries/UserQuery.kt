package com.keyskey.ktknowledge.handlers.graphql.queries

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toInt
import com.keyskey.ktknowledge.usecases.user.UserSearcher
import org.springframework.stereotype.Component

@Component
class UserQuery(private val userSearcher: UserSearcher): Query {
    @Suppress("unused")
    fun newUsers(): List<UserType> {
        return userSearcher
            .findNewUsers()
            .map { UserType(it) }
    }

    fun user(id: ID): UserType? {
        val intId = id.toInt()

        return userSearcher
            .findOne(intId)
            ?.let { UserType(it) }
    }
}
