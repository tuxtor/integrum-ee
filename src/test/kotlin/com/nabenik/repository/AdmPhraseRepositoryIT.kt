package com.nabenik.repository

import com.nabenik.model.AdmPhrase
import com.nabenik.util.createBasePersistenceWar
import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.spec.WebArchive
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(Arquillian::class)
class AdmPhraseRepositoryIT {

    @Inject
    private lateinit var admPhraseRepository: AdmPhraseRepository


    companion object ArquillianTester{

        @JvmStatic
        @Deployment
        fun bootstrapTest(): WebArchive {
            val war = createBasePersistenceWar()
                    .addClass(AdmPhraseRepository::class.java)
                    .addAsWebInfResource("test-beans.xml", "beans.xml")
            println(war.toString(true))

            return war
        }


    }

    @Test
    fun testPersistance(){
        val phrase = AdmPhrase( author = "Torvalds", phrase = "Fck you Nvidia")
        admPhraseRepository.create(phrase)
        assertNotNull(phrase.phraseId)
    }

}

