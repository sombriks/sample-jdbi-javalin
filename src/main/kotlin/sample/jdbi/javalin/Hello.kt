package sample.jdbi.javalin

import io.javalin.Javalin

fun main() {

    Config.migrateLatest()

    val app = Javalin.create(/*config*/)
        .get("/") { ctx -> ctx.result("Hello World") }
        .start(7070)
}

