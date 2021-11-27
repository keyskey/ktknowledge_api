package com.keyskey.ktknowledge.usecases.commands

import com.keyskey.ktknowledge.repositories.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DeleteUserCommand(private val userRepository: UserRepository) {
    @Transactional
    fun call(id: Int): Int {
        userRepository.delete(id)

        return id
    }
}
