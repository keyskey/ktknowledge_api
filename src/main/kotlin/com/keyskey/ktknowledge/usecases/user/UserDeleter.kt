package com.keyskey.ktknowledge.usecases.user

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.entities.UsersRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDeleter(private val usersRepository: UsersRepository, private val usersQuery: UsersQuery) {
    @Transactional
    fun call(id: Int): User {
        val user = usersQuery.findById(id)
        checkNotNull(user)
        usersRepository.delete(user.id)

        return user
    }
}
