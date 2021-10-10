package com.keyskey.ktknowledge.queries

import com.expediagroup.graphql.server.operations.Query
import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.repositories.UserRepository
import org.springframework.stereotype.Component

@Component
class UserQuery(private val userRepository: UserRepository): Query {
    fun users(): List<User> {
        return userRepository.findAll()
    }
}