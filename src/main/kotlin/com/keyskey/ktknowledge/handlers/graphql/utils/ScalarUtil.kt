package com.keyskey.ktknowledge.handlers.graphql.utils

import com.expediagroup.graphql.generator.scalars.ID

fun ID.toInt(): Int = this.toString().toInt()

fun Int.toID(): ID = ID(this.toString())
