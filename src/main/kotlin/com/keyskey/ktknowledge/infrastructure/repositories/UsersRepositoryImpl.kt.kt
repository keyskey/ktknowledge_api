package com.keyskey.ktknowledge.infrastructure.repositories

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.entities.UsersRepository
import com.keyskey.ktknowledge.database.Users
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.springframework.stereotype.Repository

@Repository
class UsersRepositoryImpl(val database: Database): UsersRepository {
    override fun create(user: User): User {
        val id = database.insertAndGenerateKey(Users) {
            set(it.name, user.name)
            set(it.email, user.email)
            set(it.password, user.password)
            set(it.createdAt, user.createdAt)
            set(it.updatedAt, user.updatedAt)
        }.toString().toInt()

        return user.copy(id = id)
    }

    override fun update(user: User) {
        database.update(Users) {
            set(it.name, user.name)
            set(it.email, user.email)
            set(it.password, user.password)
            set(it.createdAt, user.createdAt)
            set(it.updatedAt, user.updatedAt)
            where { it.id eq user.id }
        }
    }

    override fun delete(id: Int) {
        database.delete(Users) {
            it.id eq id
        }
    }
}
