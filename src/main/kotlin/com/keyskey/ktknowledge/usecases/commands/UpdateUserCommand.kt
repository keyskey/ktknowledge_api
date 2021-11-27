package com.keyskey.ktknowledge.usecases.commands

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.repositories.UserRepository
import com.keyskey.ktknowledge.utils.timestamp
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateUserCommand(private val userRepository: UserRepository) {
    @Transactional
    fun call(id: Int, name: String): User {
        val user = userRepository.findById(id)
        checkNotNull(user)
        val updatedUser = user.copy(
            name = name,
            updatedAt = timestamp()
        )
        userRepository.update(updatedUser)

        return updatedUser
    }
}
