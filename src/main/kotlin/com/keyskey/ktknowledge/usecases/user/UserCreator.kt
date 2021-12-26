package com.keyskey.ktknowledge.usecases.user

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.entities.UsersRepository
import com.keyskey.ktknowledge.utils.timestamp
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserCreator(private val usersRepository: UsersRepository) {
    @Transactional
    fun call(name: String, email: String, password: String): User {
        val now = timestamp()
        val user = User(
            name = name,
            email = email,
            password = password,
            createdAt = now,
            updatedAt = now
        )
        UserValidator.call(user)

        return usersRepository.create(user)
    }
}
