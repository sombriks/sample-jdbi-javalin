package sample.jdbi.javalin.services

import org.jdbi.v3.core.Jdbi
import sample.jdbi.javalin.Config
import sample.jdbi.javalin.models.Product

class ProductService(private val db: Jdbi = Config.db) {

    fun find(id: Int): Product = db.withHandle<Product, Exception> {
        it.createQuery("select * from clients where id = :id")
            .bind("id", id).mapToBean(Product::class.java).one()
    }

    fun list(q: String = ""): List<Product> = db.withHandle<List<Product>, Exception> {
        it.createQuery("select * from products where description like :q")
            .bind("q", "%$q%").mapToBean(Product::class.java).list()
    }

    fun insert(newProduct: Product) {
        db.useHandle<Exception> {
            it.createUpdate(
                """
                    insert into products (description, price) 
                    values (:description, :price)
                    """
            ).bindBean(newProduct).execute()
        }
    }

    fun update(product: Product) {
        db.useHandle<Exception> {
            it.createUpdate(
                """
                update products
                set description = :description,
                price = :price
                where id = :id
                """
            ).bindBean(product).execute()
        }
    }

    fun del(id: Int) {
        db.useHandle<Exception> {
            it.createUpdate("delete from products where id = :id")
                .bind("id", id).execute()
        }
    }
}

