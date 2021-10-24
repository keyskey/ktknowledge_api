package com.keyskey.ktknowledge.repositories

import com.keyskey.ktknowledge.database.Users
import com.keyskey.ktknowledge.entities.User
import org.ktorm.database.Database
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select
import org.springframework.stereotype.Repository

@Repository
class UserRepository(val database: Database) {
    fun findAll(): List<User> {
        return database
            .from(Users)
            .select(Users.id, Users.name)
            .map { row -> User(row[Users.id], row[Users.name]) }
    }
}