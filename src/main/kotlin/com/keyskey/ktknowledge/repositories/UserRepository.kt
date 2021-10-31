package com.keyskey.ktknowledge.repositories

import com.keyskey.ktknowledge.repositories.database.UserRecord
import com.keyskey.ktknowledge.repositories.database.Users
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class UserRepository(val database: Database) {
    fun QueryRowSet.toRecord(): UserRecord = UserRecord(
        id = this[Users.id],
        name = this[Users.name],
        createdAt = this[Users.createdAt],
        updatedAt = this[Users.updatedAt]
    )

    fun findAll(): List<UserRecord> {
        return database
            .from(Users)
            .select()
            .map { it.toRecord() }
    }

    fun findById(id: Int): UserRecord? {
        return database
            .from(Users)
            .select()
            .where { Users.id eq id }
            .limit(1)
            .map { it.toRecord() }
            .singleOrNull()
    }

    fun create(name: String): UserRecord? {
        val id = database.insertAndGenerateKey(Users) {
            set(it.name, name)
            set(it.createdAt, now())
            set(it.updatedAt, now())
        } as Int?

        return id?.let { findById(it) }
    }

    fun update(id: Int, name: String): UserRecord? {
        val numUpdatedRows = database.update(Users) {
            set(it.name, name)
            set(it.updatedAt, now())
            where { it.id eq id }
        }

        return if (numUpdatedRows > 0) findById(id) else null
    }

    fun delete(id: Int): Boolean {
        val numDeletedRows = database.delete(Users) { it.id eq id }

        return numDeletedRows > 0
    }

    private fun now(): LocalDateTime = LocalDateTime.now()
}
