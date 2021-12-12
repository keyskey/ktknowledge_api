package com.keyskey.ktknowledge.usecases.commands

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.repositories.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteUserCommand(private val userRepository: UserRepository) {
    @Transactional
    fun call(id: Int): User {
        val user = userRepository.findById(id)
        checkNotNull(user)
        userRepository.delete(user.id)

        return user
    }
}
