package br.com.zup.casadocodigo.validation

import br.com.zup.casadocodigo.author.AuthorService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class EmailAvailableValidator(private var authorService: AuthorService): ConstraintValidator<EmailAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }
        return authorService.emailAvailable(value)
    }

}