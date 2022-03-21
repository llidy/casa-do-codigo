package br.com.zup.casadocodigo.author

import br.com.zup.casadocodigo.validation.EmailAvailableValidator
import org.springframework.stereotype.Service
import org.springframework.validation.Errors
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.InitBinder
import java.util.*
import javax.validation.Validator

@Service
class AuthorService(private val authorRepository: AuthorRepository) {

    fun create(author: Author) {
        authorRepository.save(author)
    }

    fun emailAvailable(email: String): Boolean{
        return !authorRepository.existsByEmail(email)
    }

    fun getAuthorId(id: Int): Author {
        return authorRepository.findById(id).orElseThrow()
    }

}
