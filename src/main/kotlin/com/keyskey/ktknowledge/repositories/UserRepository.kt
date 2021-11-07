package com.keyskey.ktknowledge.repositories

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.entities.UserProperty
import com.keyskey.ktknowledge.repositories.database.Users
import com.keyskey.ktknowledge.repositories.database.timestamp
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.springframework.stereotype.Repository

@Repository
class UserRepository(val database: Database) {
    private fun QueryRowSet.toUser(): User {
        val id = this[Users.id]
        val name = this[Users.name]
        val createdAt = this[Users.createdAt]
        val updatedAt = this[Users.updatedAt]

        checkNotNull(id)
        checkNotNull(name)
        checkNotNull(createdAt)
        checkNotNull(updatedAt)

        return User(id, UserProperty(name, createdAt, updatedAt))
    }

    fun findAll(): List<User> {
        return database
            .from(Users)
            .select()
            .map { it.toUser() }
    }

    fun findById(id: Int): User? {
        return database
            .from(Users)
            .select()
            .where { Users.id eq id }
            .limit(1)
            .map { it.toUser() }
            .singleOrNull()
    }

    fun create(name: String): User {
        val property = UserProperty(name, timestamp(), timestamp())
        val id = database.insertAndGenerateKey(Users) {
            set(it.name, property.name)
            set(it.createdAt, property.createdAt)
            set(it.updatedAt, property.updatedAt)
        }.toString().toInt()

        return User(id, property)
    }

    fun updateName(id: Int, name: String): User? {
        val numRowsAffected = database.update(Users) {
            set(it.name, name)
            set(it.updatedAt, timestamp())
            where { it.id eq id }
        }

        return if (numRowsAffected > 0) {
            findById(id)
        } else {
            null
        }
    }

    fun delete(id: Int): Int? {
        val numRowsAffected = database.delete(Users) { it.id eq id }

        return if (numRowsAffected > 0) {
            id
        } else {
            null
        }
    }
}
