package sample.jdbi.javalin.controllers

import io.javalin.http.Context
import sample.jdbi.javalin.models.Client
import sample.jdbi.javalin.services.ClientService

class ClientController(private val service: ClientService = ClientService()) {

    fun find(ctx: Context) = ctx.json(service.find(ctx.pathParam("id").toInt()))

    fun list(ctx: Context) = ctx.json(service.list(ctx.queryParam("q")))

    fun insert(ctx: Context) = service.insert(ctx.bodyAsClass(Client::class.java))

    fun update(ctx: Context) {
        var id = ctx.pathParam("id").toInt()
        var client = ctx.bodyAsClass(Client::class.java)
        client.id = id
        service.update(client)
    }

    fun del(ctx: Context) = service.del(ctx.pathParam("id").toInt())
}
