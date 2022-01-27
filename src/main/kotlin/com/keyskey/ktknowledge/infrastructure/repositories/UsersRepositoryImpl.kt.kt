package com.keyskey.ktknowledge.infrastructure.repositories

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.entities.UsersRepository
import com.keyskey.ktknowledge.infrastructure.database.Users
import org.ktorm.database.Database
import org.ktorm.dsl.*
import org.ktorm.entity.*
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

interface UserDao : Entity<UserDao> {
    companion object : Entity.Factory<UserDao>()

    val id: Int
    var name: String
    var email: String
    var password: String
    var createdAt: LocalDateTime
    var updatedAt: LocalDateTime
}

@Repository
class UsersRepositoryImpl(val database: Database): UsersRepository {
    // insert時に生成されたidを取得する手段がない
    override fun create(user: User): User {
        val userDao = buildDao(user)
        users().add(userDao)

        return user
    }

    override fun update(user: User) {
        val userDao = buildDao(user)
        users().update(userDao)
    }

    override fun delete(id: Int) {
        users().removeIf { it.id eq id }
    }

    private fun buildDao(user: User): UserDao {
        return UserDao {
            name = user.name
            email = user.email
            password = user.password
            createdAt = user.createdAt
            updatedAt = user.updatedAt
        }
    }

    private fun users() = database.sequenceOf(Users)
}
