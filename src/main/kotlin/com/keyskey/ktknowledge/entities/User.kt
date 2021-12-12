package com.keyskey.ktknowledge.entities

import com.keyskey.ktknowledge.utils.throwOnFailure
import com.keyskey.ktknowledge.utils.timestamp
import org.valiktor.functions.hasSize
import org.valiktor.functions.isEmail
import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.validate
import java.time.LocalDateTime

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    init {
        runCatching {
            validate(this) {
                validate(User::id).isGreaterThanOrEqualTo(0)
                validate(User::name).hasSize(min = 1, max = 20)
                validate(User::email).isEmail()
            }
        }.throwOnFailure()
    }

    companion object {
        fun build(id: Int = 0, name: String, email: String, password: String): User {
            val now = timestamp()
            return User(
                id = id,
                name = name,
                email = email,
                password = password,
                createdAt = now,
                updatedAt = now
            )
        }
    }
}
