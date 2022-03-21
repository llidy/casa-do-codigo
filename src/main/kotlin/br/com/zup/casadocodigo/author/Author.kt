package br.com.zup.casadocodigo.author

import br.com.zup.casadocodigo.validation.EmailAvailable
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity(name = "author")
data class Author(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @Column
    @field:NotEmpty
    val name: String,

    @Column
    @field:NotEmpty
    @Email
    val email: String,

    @Column
    @field:NotEmpty
    @field:Size(max = 400)
    val description: String,

    @Column
    @field:NotNull
    val createdAt: LocalDateTime = LocalDateTime.now()
)
