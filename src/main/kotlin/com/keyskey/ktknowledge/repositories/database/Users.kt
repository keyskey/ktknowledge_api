package com.keyskey.ktknowledge.repositories.database

import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.int
import org.ktorm.schema.varchar
import java.time.LocalDateTime

object Users: Table<Nothing>("users") {
    val id = int("id").primaryKey()
    val name = varchar("name")
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}

data class UserRecord(val id: Int?, val name: String?, val createdAt: LocalDateTime?, val updatedAt: LocalDateTime?)
