package com.nabenik.util

import org.flywaydb.core.Flyway
import org.slf4j.Logger
import javax.annotation.PostConstruct
import javax.ejb.EJBException
import javax.ejb.Singleton
import javax.ejb.Startup
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.naming.InitialContext
import javax.sql.DataSource

@ApplicationScoped
@Singleton
@Startup
class FlywayBootstrapper{

    @Inject
    private lateinit var logger:Logger

    @Throws(EJBException::class)
    @PostConstruct
    fun init() {

        val ctx = InitialContext()
        val dataSource = ctx.lookup("java:app/jdbc/integrumdb") as? DataSource

        dataSource.let {
            val flywayConfig = Flyway.configure()
                    .dataSource(it)
                    .locations("db/postgresql")

            val flyway = flywayConfig.load()
            val migrationInfo = flyway.info().current()

            if (migrationInfo == null) {
                logger.info("No existing database at the actual datasource")
            }
            else {
                logger.info("Found a database with the version: ${migrationInfo.version} : ${migrationInfo.description}")
            }

            flyway.migrate()
            logger.info("Successfully migrated to database version: {}", flyway.info().current().version)
            it?.connection?.close()
            ctx.close()
        }
    }
}
