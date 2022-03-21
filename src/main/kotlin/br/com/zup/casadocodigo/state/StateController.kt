package br.com.zup.casadocodigo.country

import br.com.zup.casadocodigo.extension.toStateModel
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/states")
class StateController(private val serviceState: StateService,
                      private val serviceCountry: CountryService
) {

    @PostMapping
    fun createState(@RequestBody @Valid requestState: StateRequest){

        val country = serviceCountry.getCountryId(requestState.countryId)

       serviceState.createState(requestState.toStateModel(country), requestState)
    }

    @GetMapping("/{id}")
    fun getStateId(@PathVariable id: Int){
        serviceState.getStateId(id)
    }

    @GetMapping
    fun getAllStates(): List<StateModel>{
        return serviceState.getAllStates()
    }

    @GetMapping("/all")
    fun duplicatedStateForCountry(@RequestParam name: String, countryId: Int): Optional<StateModel> {
        return serviceState.duplicatedStateForCountry(name, countryId)
    }
}