package com.keyskey.ktknowledge.entities

import java.time.LocalDateTime

data class User(
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)

interface UsersRepository {
    fun create(user: User): User
    fun update(user: User)
    fun delete(id: Int)
}
