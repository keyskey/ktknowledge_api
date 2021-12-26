package com.keyskey.ktknowledge.usecases.user

import com.keyskey.ktknowledge.entities.User
import com.keyskey.ktknowledge.utils.throwOnFailure
import org.valiktor.functions.hasSize
import org.valiktor.functions.isEmail
import org.valiktor.functions.isGreaterThanOrEqualTo
import org.valiktor.validate

object UserValidator {
    fun call(user: User) {
        runCatching {
            validate(user) {
                validate(User::id).isGreaterThanOrEqualTo(0)
                validate(User::name).hasSize(min = 1, max = 20)
                validate(User::email).isEmail()
            }
        }.throwOnFailure()
    }
}
