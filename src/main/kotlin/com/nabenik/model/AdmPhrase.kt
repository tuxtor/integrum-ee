package com.nabenik.model

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "adm_phrase")
@TableGenerator(name = "admPhraseIdGenerator", table = "adm_sequence_generator", pkColumnName = "id_sequence", valueColumnName = "sequence_value", pkColumnValue = "adm_phrase", allocationSize = 1)
data class AdmPhrase(
        @Id
        @GeneratedValue(strategy = GenerationType.TABLE, generator = "admPhraseIdGenerator")
        @Column(name = "phrase_id")
        var phraseId:Long? = null,
        var author:String = "",
        var phrase:String = ""
)