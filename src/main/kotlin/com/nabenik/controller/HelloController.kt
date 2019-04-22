package com.nabenik.controller

import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/hello")
class HelloController{

    @Inject
    @ConfigProperty(name ="JAVA_HOME", defaultValue = "JAVA_HOME")
    lateinit var javaHome:String

    @GET
    fun doHello() = "There is no place like $javaHome"

}