package com.keyskey.ktknowledge.handlers.graphql.utils

import com.expediagroup.graphql.generator.scalars.ID

fun ID.toIntOrNull(): Int? = this.toString().toIntOrNull()

fun Int.toID(): ID = ID(this.toString())
