package com.keyskey.ktknowledge.handlers.graphql.mutations

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.keyskey.ktknowledge.entities.UserProperty
import com.keyskey.ktknowledge.handlers.graphql.types.UserType
import com.keyskey.ktknowledge.handlers.graphql.types.toUserType
import com.keyskey.ktknowledge.handlers.graphql.utils.toID
import com.keyskey.ktknowledge.handlers.graphql.utils.toIntOrNull
import com.keyskey.ktknowledge.repositories.UserRepository
import org.springframework.stereotype.Component

@Component
class UserMutation(private val userRepository: UserRepository): Mutation {
    fun createUser(name: String): UserType {
        return userRepository
            .create(UserProperty(name))
            .toUserType()
    }

    fun updateUser(id: ID, name: String): UserType? {
        val intId = id.toIntOrNull()
        intId ?: return null

        val userId = userRepository.update(intId, UserProperty(name))
        userId ?: return null

        return userRepository
            .findById(userId)
            ?.toUserType()
    }

    fun deleteUser(id: ID): ID? {
        val intId = id.toIntOrNull()
        intId ?: return null

        return userRepository
            .delete(intId)
            ?.toID()
    }
}
