package com.keyskey.ktknowledge.usecases.commands

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.repositories.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateUserCommand(private val userRepository: UserRepository) {
    @Transactional
    fun call(name: String): User {
        val userId = userRepository.findAll().size + 1
        val user = User.build(userId, name)
        userRepository.create(user)

        return user
    }
}
