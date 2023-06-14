package sample.jdbi.javalin

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import liquibase.Contexts
import liquibase.LabelExpression
import liquibase.Liquibase
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import org.jdbi.v3.core.Jdbi
import java.io.PrintWriter
import java.io.Writer
import javax.sql.DataSource

object Config {

    private val dataSource: DataSource by lazy {
        HikariDataSource(HikariConfig("/datasource.properties"))
    }

    val db: Jdbi by lazy {
        Jdbi.create(dataSource)
    }

    fun migrateLatest() {
        val connection = JdbcConnection(dataSource.connection)
        connection.use {
            Liquibase(
                "/db/changelog/root.xml", ClassLoaderResourceAccessor(), connection
            ).update()
        }
    }

}
