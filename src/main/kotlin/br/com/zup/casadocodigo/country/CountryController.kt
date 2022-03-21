package br.com.zup.casadocodigo.country

import br.com.zup.casadocodigo.extension.toCountryModel
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/countries")
class CountryController(private val serviceCountry: CountryService) {

    @PostMapping
    fun createCountry(@RequestBody @Valid requestCountry: CountryRequest){
        serviceCountry.createCountry(requestCountry.toCountryModel())
    }

    @GetMapping("/{id}")
    fun getCountryId(@PathVariable id: Int): CountryModel{
        return serviceCountry.getCountryId(id)
    }

    @GetMapping
    fun getAllCountries(): List<CountryModel>{
        return serviceCountry.getAllCountries()
    }
}