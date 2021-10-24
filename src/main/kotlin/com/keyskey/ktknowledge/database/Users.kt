package com.keyskey.ktknowledge.database

import org.ktorm.schema.Table
import org.ktorm.schema.datetime
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object Users: Table<Nothing>("users") {
    val id = int("id").primaryKey()
    val name = varchar("name")
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}