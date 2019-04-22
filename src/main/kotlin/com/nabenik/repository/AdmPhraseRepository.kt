package com.nabenik.repository

import com.nabenik.model.AdmPhrase
import org.slf4j.Logger
import javax.annotation.PostConstruct
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.persistence.EntityManager

@RequestScoped
class AdmPhraseRepository @Inject constructor() {

    @Inject
    private lateinit var em:EntityManager

    @PostConstruct
    fun init() {
        println ("Booting repository")
    }

    fun create(admPhrase:AdmPhrase) = em.persist(admPhrase)

    fun update(admPhrase:AdmPhrase) = em.merge(admPhrase)

    fun findById(phraseId: Long) = em.find(AdmPhrase::class.java, phraseId)

    fun delete(admPhrase: AdmPhrase) = em.remove(admPhrase)

    fun listAll(author: String, phrase: String): List<AdmPhrase> {

        val query = """SELECT p FROM AdmPhrase p
            where p.author LIKE :author
            and p.phrase LIKE :phrase
        """

        return em.createQuery(query, AdmPhrase::class.java)
                .setParameter("author", "%$author%")
                .setParameter("phrase", "%$phrase%")
                .resultList
    }

}