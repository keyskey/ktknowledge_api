package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toInt
import com.keyskey.ktknowledge.usecases.user.UserDeleter
import org.springframework.stereotype.Component

@Component
class DeleteUserMutation(private val userDeleter: UserDeleter): Mutation {
    @Suppress("unused")
    fun deleteUser(id: ID): UserType {
        val intId = id.toInt()

        return userDeleter
            .call(intId)
            .let { UserType(it) }
    }
}
