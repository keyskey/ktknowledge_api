package com.keyskey.ktknowledge.usecases.user

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.entities.UsersRepository
import com.keyskey.ktknowledge.utils.timestamp
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserUpdater(private val usersRepository: UsersRepository, private val usersQuery: UsersQuery) {
    @Transactional
    fun call(id: Int, name: String): User {
        val user = usersQuery.findById(id)
        checkNotNull(user)
        val updatedUser = user.copy(
            name = name,
            updatedAt = timestamp()
        )
        UserValidator.call(updatedUser)
        usersRepository.update(updatedUser)

        return updatedUser
    }
}
