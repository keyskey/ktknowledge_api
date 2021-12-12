package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toInt
import com.keyskey.ktknowledge.usecases.commands.DeleteUserCommand
import org.springframework.stereotype.Component

@Component
class DeleteUserMutation(private val deleteUserCommand: DeleteUserCommand): Mutation {
    fun deleteUser(id: ID): UserType {
        val intId = id.toInt()
        val response = deleteUserCommand
            .call(intId)
            .toUserType()

        return response
    }
}
