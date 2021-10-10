package com.keyskey.ktknowledge.repositories

import com.keyskey.ktknowledge.entities.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository {
    fun findAll(): List<User> {
        return listOf(
            User(1, "user1"),
            User(2, "user2")
        )
    }
}