package sample.jdbi.javalin

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import sample.jdbi.javalin.controllers.ClientController

fun main() {

    // keeping database sane
    Config.migrateLatest()

    val clientController = ClientController()

    val app = Javalin.create(/*config*/)

    app.get("/") { ctx -> ctx.result("Hello world") }
    app.routes {
        path("clients") {
            get(clientController::list)
            post(clientController::insert)
            path("{id}") {
                get(clientController::find)
                put(clientController::update)
                delete(clientController::del)
            }
        }
    }
    app.start(7070)
}
