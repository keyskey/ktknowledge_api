package com.keyskey.ktknowledge.handlers.graphql.utils

import com.expediagroup.graphql.generator.scalars.ID
import graphql.relay.Relay

fun ID.toInt(): Int {
    // IDは `User:1` のような値がBase64エンコーディングされたものであることを期待している
    // Relay#fromGlobalId はこのIDをデコードした上で`:`でsplitし、type: "User と id: "1" を持つResolvedGlobalIdのインスタンスを返してくれる
    val globalId: Relay.ResolvedGlobalId = Relay().fromGlobalId(this.toString())

    return globalId.id.trim().toInt()
}

fun Int.toID(type: String): ID {
    val globalId: String = Relay().toGlobalId(type, this.toString())

    return ID(globalId)
}
