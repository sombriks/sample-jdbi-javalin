package sample.jdbi.javalin

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.http.staticfiles.Location
import io.javalin.vue.VueComponent
import sample.jdbi.javalin.controllers.ClientController

fun main() {

    // keeping database sane
    Config.migrateLatest()

    val clientController = ClientController()

    val app = Javalin.create {
        it.staticFiles.enableWebjars()
        it.vue.vueAppName = "app"
        it.vue.isDevFunction = { false }
//        it.vue.rootDirectory("/vue", Location.CLASSPATH, Config::class.java)
    }

    app.get("/", VueComponent("hello-world"))
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
