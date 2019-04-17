package com.nabenik.repository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloEndpoint {

    @GET
    public String doHello(){
        return "Hello from integrum EE";
    }
}
