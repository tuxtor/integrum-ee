package com.nabenik.controller

import com.nabenik.model.AdmPhrase
import com.nabenik.repository.AdmPhraseRepository
import org.slf4j.Logger
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.core.UriBuilder

@Path("/phrases")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class AdmPhraseController{

    @Inject
    private lateinit var admPhraseRepository: AdmPhraseRepository

    @Inject
    private lateinit var logger: Logger

    @GET
    fun findAll(@QueryParam("author") @DefaultValue("%") author: String,
                @QueryParam("phrase") @DefaultValue("%") phrase: String) = admPhraseRepository.listAll(author, phrase)

    @GET
    @Path("/{id:[0-9][0-9]*}")
    fun findById(@PathParam("id") id:Long) = admPhraseRepository.findById(id)

    @PUT
    fun create(phrase: AdmPhrase): Response {
        admPhraseRepository.create(phrase)
        return Response.created(UriBuilder.fromResource(this::class.java)
                .path(phrase.phraseId.toString()).build()).build()
    }

    @POST
    @Path("/{id:[0-9][0-9]*}")
    fun update(@PathParam("id") id: Long?, phrase: AdmPhrase): Response {
        if(id != phrase.phraseId) return Response.status(Response.Status.NOT_FOUND).build()

        val updatedEntity = admPhraseRepository.update(phrase)
        return Response.ok(updatedEntity).build()
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    fun delete(@PathParam("id") id: Long): Response {
        val updatedEntity = admPhraseRepository.findById(id) ?:
            return Response.status(Response.Status.NOT_FOUND).build()
        admPhraseRepository.delete(updatedEntity)
        return Response.ok().build()
    }

}