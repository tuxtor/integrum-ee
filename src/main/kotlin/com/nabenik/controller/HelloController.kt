package com.nabenik.controller

import org.eclipse.microprofile.config.inject.ConfigProperty
import java.net.InetAddress
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/hello")
class HelloController{

    @Inject
    @ConfigProperty(name ="JAVA_HOME", defaultValue = "JAVA_HOME")
    lateinit var javaHome:String

    val ip = InetAddress.getLocalHost()

    @GET
    fun doHello() = "No hay lugar como  $javaHome, ejecutandose en la siguiente direccion $ip"


    @GET
    @Path("/meso")
    fun doHolaXela() = "Hola amigos de la Meso, me gusta C# :V"
}
