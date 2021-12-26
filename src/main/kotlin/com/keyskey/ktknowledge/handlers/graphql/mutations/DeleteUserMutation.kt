package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toInt
import com.keyskey.ktknowledge.usecases.user.UserDeleter
import org.springframework.stereotype.Component

@Component
class DeleteUserMutation(private val userDeleter: UserDeleter): Mutation {
    fun deleteUser(id: ID): UserType {
        val intId = id.toInt()
        val response = userDeleter
            .call(intId)
            .toUserType()

        return response
    }
}
