package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.usecases.commands.CreateUserCommand
import org.springframework.stereotype.Component

@Component
class CreateUserMutation(private val createUserCommand: CreateUserCommand): Mutation {
    fun createUser(name: String, email: String, password: String): UserType {
        val response = createUserCommand
            .call(
                name = name,
                email = email,
                password = password
            )
            .toUserType()

        return response
    }
}
