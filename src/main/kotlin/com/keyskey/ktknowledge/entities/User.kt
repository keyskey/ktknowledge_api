package com.keyskey.ktknowledge.entities

import com.keyskey.ktknowledge.utils.throwOnFailure
import com.keyskey.ktknowledge.utils.timestamp
import org.valiktor.functions.hasSize
import org.valiktor.functions.isPositive
import org.valiktor.validate
import java.time.LocalDateTime

data class User(
    val id: Int,
    val name: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    init {
        runCatching {
            validate(this) {
                validate(User::id).isPositive()
                validate(User::name).hasSize(min = 1, max = 20)
            }
        }.throwOnFailure()
    }

    companion object {
        fun build(id: Int, name: String): User {
            val now = timestamp()
            return User(id, name, now, now)
        }
    }
}
