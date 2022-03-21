package br.com.zup.casadocodigo.country

import br.com.zup.casadocodigo.validation.UniqueValue
import com.fasterxml.jackson.annotation.JsonAlias
import org.springframework.stereotype.Component
import javax.persistence.ManyToOne
import javax.validation.constraints.NotEmpty

data class StateRequest (

    @field:NotEmpty
    val name: String,

    @ManyToOne
    @JsonAlias("countries_id")
    val countryId: Int
    )
