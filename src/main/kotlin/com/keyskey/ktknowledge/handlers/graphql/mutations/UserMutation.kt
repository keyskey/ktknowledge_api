package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toIntOrNull
import com.keyskey.ktknowledge.repositories.UserRepository
import org.springframework.stereotype.Component

@Component
class UserMutation(private val userRepository: UserRepository): Mutation {
    fun createUser(name: String): UserType? {
        return userRepository
            .create(name)
            ?.toUserType()
    }

    fun updateUser(id: ID, name: String): UserType? {
        val user = id.toIntOrNull()?.let {
            userRepository
                .update(it, name)
                ?.toUserType()
        }

        return user
    }

    fun deleteUser(id: ID): ID? {
        val success = id.toIntOrNull()?.let { userRepository.delete(it) }

        return if (success!!) id else null
    }
}
