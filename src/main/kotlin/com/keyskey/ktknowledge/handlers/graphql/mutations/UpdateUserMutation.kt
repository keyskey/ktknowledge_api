package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toInt
import com.keyskey.ktknowledge.usecases.user.UserUpdater
import org.springframework.stereotype.Component

data class UpdateUserInput(val id: ID, val name: String)

@Component
class UpdateUserMutation(private val userUpdator: UserUpdater): Mutation {
    fun updateUser(input: UpdateUserInput): UserType {
        val intId = input.id.toInt()
        val response = userUpdator
            .call(intId, input.name)
            .toUserType()

        return response
    }
}
