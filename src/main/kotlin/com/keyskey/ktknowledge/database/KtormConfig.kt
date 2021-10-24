package com.keyskey.ktknowledge.database

import org.ktorm.database.Database
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class KtormConfig(val dataSource: DataSource) {
    @Bean
    fun database(): Database = Database.connectWithSpringSupport(dataSource)
}