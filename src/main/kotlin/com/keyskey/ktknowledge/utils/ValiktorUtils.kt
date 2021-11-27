package com.keyskey.ktknowledge.utils

import org.valiktor.ConstraintViolationException
import org.valiktor.i18n.mapToMessage
import java.util.Locale

fun <T> Result<T>.throwOnFailure() {
    if (this.isFailure) {
        val errorMessage = (this.exceptionOrNull() as ConstraintViolationException).getMessage()
        throw IllegalArgumentException(errorMessage)
    }
}

fun ConstraintViolationException.getMessage(): String {
    return this.constraintViolations
        .mapToMessage(locale = Locale.ENGLISH)
        .joinToString(separator = ",") { "${it.property}: ${it.message}" }
}
