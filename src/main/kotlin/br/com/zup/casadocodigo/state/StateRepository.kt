package br.com.zup.casadocodigo.state

import br.com.zup.casadocodigo.country.StateModel
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StateRepository: JpaRepository<StateModel, Int> {
    fun findByNameAndCountryModelId(name: String, countryId: Int): Optional<StateModel>

}
