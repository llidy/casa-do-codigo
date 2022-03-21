package br.com.zup.casadocodigo.country

import org.springframework.stereotype.Service
import java.util.*

@Service
class CountryService(private val repositoryCountry: CountryRepository) {

    fun createCountry(countryModel: CountryModel){
        repositoryCountry.save(countryModel)
    }

    fun getCountryId(id: Int): CountryModel {
        return repositoryCountry.findById(id).orElseThrow()
    }

    fun getAllCountries(): List<CountryModel> {
        return repositoryCountry.findAll()
    }

}
