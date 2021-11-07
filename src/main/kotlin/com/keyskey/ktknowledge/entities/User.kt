package com.keyskey.ktknowledge.entities

import java.time.LocalDateTime

interface UserDefinition {
    val name: String
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime
}

data class UserProperty(
    override val name: String,
    override val createdAt: LocalDateTime,
    override val updatedAt: LocalDateTime
): UserDefinition

data class User(
    val id: Int,
    private val property: UserProperty,
): UserDefinition by property
