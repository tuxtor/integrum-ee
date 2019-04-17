package com.nabenik.util

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default
import javax.enterprise.inject.Disposes
import javax.enterprise.inject.Produces
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.PersistenceUnit

/**
 * Global scoped Entity Manager Producer, aimed for CDI Repositories and extensions -e.g. DeltaSpike-
 */
@ApplicationScoped
class EntityManagerProducer {

    @PersistenceUnit
    private lateinit var entityManagerFactory: EntityManagerFactory

    @Produces
    @Default
    @RequestScoped
    fun create(): EntityManager = this.entityManagerFactory.createEntityManager()

    fun dispose(@Disposes @Default entityManager: EntityManager) {
        if (entityManager.isOpen) {
            entityManager.close()
        }
    }
}