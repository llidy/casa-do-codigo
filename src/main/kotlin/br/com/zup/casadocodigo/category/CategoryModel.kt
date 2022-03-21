package br.com.zup.casadocodigo.category

import br.com.zup.casadocodigo.validation.NameAvailable
import javax.annotation.processing.Generated
import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity(name = "categories")
class CategoryModel(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @NotEmpty
    @Column
    val name: String
)