package br.com.zup.casadocodigo.country

import br.com.zup.casadocodigo.validation.UniqueValue
import javax.validation.constraints.NotEmpty

class CountryRequest (

    @UniqueValue(domainClass = CountryModel::class, fieldName = "name", message = "País já cadastrado" )
    @field:NotEmpty
    val name: String
    )
