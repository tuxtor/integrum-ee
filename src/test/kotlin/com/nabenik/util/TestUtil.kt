package com.nabenik.util

import org.jboss.shrinkwrap.api.ShrinkWrap
import org.jboss.shrinkwrap.api.asset.EmptyAsset
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.jboss.shrinkwrap.resolver.api.maven.Maven
import com.nabenik.util.FlywayBootstrapper

fun createBasePersistenceWar(): WebArchive {

    val files = Maven.resolver()
            .loadPomFromFile("pom.xml")
            .importRuntimeDependencies()
            .resolve()
            .withTransitivity()
            .asFile()

    //Creating war and adding libraries
    var war = ShrinkWrap.create(WebArchive::class.java)
            .addPackage("com.nabenik.model")
            .addPackage("com.nabenik.util")
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsLibraries(*files)

    //War exclussions (Mostly from util package)
    war = war.deleteClass(FlywayBootstrapper::class.java)

    return war
}