package com.keyskey.ktknowledge.repositories

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.repositories.database.Users
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

        return User(id, name, createdAt, updatedAt)
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

    fun create(user: User): User {
        val id = database.insertAndGenerateKey(Users) {
            set(it.name, user.name)
            set(it.createdAt, user.createdAt)
            set(it.updatedAt, user.updatedAt)
        }.toString().toInt()

        return user.copy(id = id)
    }

    fun update(user: User) {
        database.update(Users) {
            set(it.name, user.name)
            set(it.updatedAt, user.updatedAt)
            where { it.id eq user.id }
        }
    }

    fun delete(id: Int) {
        database.delete(Users) {
            it.id eq id
        }
    }
}
