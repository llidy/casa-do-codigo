package br.com.zup.casadocodigo.country

import javax.persistence.*
import javax.validation.constraints.NotEmpty

@Entity(name="states")
class StateModel (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

    @field:NotEmpty
    val name: String,

    @ManyToOne
    @JoinColumn(name="countries_id")
    val countryModel: CountryModel
        )
