package com.nabenik.controller

import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/hello")
class HelloEndpoint {

    @GET
    fun ping() =  "Java EE and Kotlin"

}
