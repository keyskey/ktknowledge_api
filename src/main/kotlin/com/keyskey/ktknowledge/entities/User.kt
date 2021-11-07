package com.keyskey.ktknowledge.entities

import java.time.LocalDateTime

interface UserDefinition {
    val name: String
}

data class UserProperty(
    override val name: String,
): UserDefinition

data class User(
    val id: Int,
    private val property: UserProperty,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
): UserDefinition by property
