package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toInt
import com.keyskey.ktknowledge.usecases.user.UserUpdater
import org.springframework.stereotype.Component

data class UpdateUserInput(val id: ID, val name: String)

@Component
class UpdateUserMutation(private val userUpdater: UserUpdater): Mutation {
    @Suppress("unused")
    fun updateUser(input: UpdateUserInput): UserType {
        val intId = input.id.toInt()

        return userUpdater
            .call(intId, input.name)
            .let { UserType(it) }
    }
}
