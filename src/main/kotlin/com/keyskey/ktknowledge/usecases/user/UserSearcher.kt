package com.keyskey.ktknowledge.usecases.user

import com.keyskey.ktknowledge.entities.User
import org.springframework.stereotype.Service
import java.time.LocalDateTime

interface UsersQuery {
    fun findById(id: Int): User?
    fun findByCreatedAtRange(from: LocalDateTime, to: LocalDateTime): List<User>
}

@Service
class UserSearcher(private val usersQuery: UsersQuery) {
    /**
     * 引数[id]で指定されたUserを1つ返す
     */
    fun findOne(id: Int): User? {
        return usersQuery.findById(id)
    }

    /**
     * 直近3日以内に作成されたUserを返す
     */
    fun findNewUsers(): List<User> {
        val now = LocalDateTime.now()
        val createdFrom = now.minusDays(3)

        return usersQuery.findByCreatedAtRange(createdFrom, now)
    }
}
