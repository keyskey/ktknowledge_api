package com.keyskey.ktknowledge.infrastructure.queries

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.infrastructure.database.Users
import com.keyskey.ktknowledge.usecases.user.UsersQuery
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class UsersQueryImpl(val database: Database): UsersQuery {
    private fun QueryRowSet.toUser(): User {
        val id = this[Users.id]
        val name = this[Users.name]
        val email = this[Users.email]
        val password = this[Users.password]
        val createdAt = this[Users.createdAt]
        val updatedAt = this[Users.updatedAt]

        checkNotNull(id)
        checkNotNull(name)
        checkNotNull(email)
        checkNotNull(password)
        checkNotNull(createdAt)
        checkNotNull(updatedAt)

        return User(
            id = id,
            name = name,
            email = email,
            password = password,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }

    override fun findById(id: Int): User? {
        return database
            .from(Users)
            .select()
            .where { Users.id eq id }
            .limit(1)
            .map { it.toUser() }
            .singleOrNull()
    }

    override fun findByCreatedAtRange(from: LocalDateTime, to: LocalDateTime): List<User> {
        return database
            .from(Users)
            .select()
            .where { (Users.createdAt greaterEq from) and (Users.createdAt lessEq to) }
            .map { it.toUser() }
    }
}
