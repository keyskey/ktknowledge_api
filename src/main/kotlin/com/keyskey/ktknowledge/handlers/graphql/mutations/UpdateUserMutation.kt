package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toInt
import com.keyskey.ktknowledge.usecases.commands.UpdateUserCommand
import org.springframework.stereotype.Component

@Component
class UpdateUserMutation(private val updateUserCommand: UpdateUserCommand): Mutation {
    fun updateUser(id: ID, name: String): UserType {
        val intId = id.toInt()
        val response = updateUserCommand
            .call(intId, name)
            .toUserType()

        return response
    }
}
