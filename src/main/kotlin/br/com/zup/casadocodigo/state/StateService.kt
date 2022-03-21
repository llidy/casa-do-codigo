package br.com.zup.casadocodigo.country

import br.com.zup.casadocodigo.exception.NotFoundException
import br.com.zup.casadocodigo.extension.toStateModel
import br.com.zup.casadocodigo.state.StateRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class StateService(private val repositoryState: StateRepository,
                   private val repository: CountryRepository

) {

    fun createState(stateModel: StateModel, stateRequest: StateRequest){
        if(duplicatedStateForCountry(stateRequest.name, stateRequest.countryId).isPresent){
            throw NotFoundException("deu certo", "deu certo mesmo")
        }

        repositoryState.save(stateModel)
    }

    fun getStateId(id: Int): StateModel{
        return repositoryState.findById(id).orElseThrow()

    }

    fun getAllStates(): List<StateModel> {
        return repositoryState.findAll()
    }

    fun duplicatedStateForCountry(name: String, countryId: Int): Optional<StateModel>{
      return repositoryState.findByNameAndCountryModelId(name, countryId)

    }


}
