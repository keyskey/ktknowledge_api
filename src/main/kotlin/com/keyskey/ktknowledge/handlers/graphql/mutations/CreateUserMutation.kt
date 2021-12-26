package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.usecases.user.UserCreator
import org.springframework.stereotype.Component

data class CreateUserInput(val name: String, val email: String, val password: String)

@Component
class CreateUserMutation(private val userCreator: UserCreator): Mutation {
    fun createUser(input: CreateUserInput): UserType {
        val response = userCreator
            .call(
                name = input.name,
                email = input.email,
                password = input.password
            )
            .toUserType()

        return response
    }
}
