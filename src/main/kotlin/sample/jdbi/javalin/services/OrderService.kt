package sample.jdbi.javalin.services

import org.jdbi.v3.core.Jdbi
import sample.jdbi.javalin.Config

class OrderService(private val db: Jdbi = Config.db) {
}
