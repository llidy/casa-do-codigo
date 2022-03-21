package br.com.zup.casadocodigo.author

import br.com.zup.casadocodigo.validation.UniqueValue
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class AuthorRequest (

    @UniqueValue(domainClass = Author::class, fieldName = "name", message = "Nome já cadastrado")
    @field:NotEmpty
    val name: String,


    @field:NotEmpty
    @field:Email(message = "O email deve ter um formato válido")
    val email: String,

    @field:NotEmpty
    @field:Size(max = 400)
    val description: String,

    )
