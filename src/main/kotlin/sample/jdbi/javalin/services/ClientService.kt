package sample.jdbi.javalin.services

import org.jdbi.v3.core.Jdbi
import sample.jdbi.javalin.Config
import sample.jdbi.javalin.models.Client

class ClientService(private val db: Jdbi = Config.db) {

    fun find(id: Int): Client = db.withHandle<Client, Exception> {
        it.createQuery("select * from clients where id = :id")
            .bind("id", id).mapToBean(Client::class.java).one()
    }

    fun list(q: String? = ""): List<Client> = db.withHandle<List<Client>, Exception> {
        it.createQuery("select * from clients where name like :q")
            .bind("q", "%$q%").mapToBean(Client::class.java).list()
    }

    fun insert(newClient: Client) {
        db.useHandle<Exception> {
            it.createUpdate("insert into clients (name) values (:name)")
                .bindBean(newClient).execute()
        }
    }

    fun update(client: Client) {
        db.useHandle<Exception> {
            it.createUpdate("update clients set name = :name where id = :id")
                .bindBean(client).execute()
        }
    }

    fun del(id: Int) {
        db.useHandle<Exception> {
            it.createUpdate("delete from clients where id = :id")
                .bind("id", id).execute()
        }
    }
}
