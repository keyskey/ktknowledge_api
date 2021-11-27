package com.keyskey.ktknowledge.usecases.commands

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.repositories.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateUserCommand(private val userRepository: UserRepository) {
    @Transactional
    fun call(name: String): User {
        val user = User.build(name = name)

        return userRepository.create(user)
    }
}
