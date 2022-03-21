package br.com.zup.casadocodigo.country

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CountryRepository: JpaRepository<CountryModel, Int> {


}
