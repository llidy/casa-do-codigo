package br.com.zup.casadocodigo.validation

import br.com.zup.casadocodigo.category.CategoryService
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class NameAvailableValidator(private var categoryService: CategoryService): ConstraintValidator<NameAvailable, String> {

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value.isNullOrEmpty()) {
            return false
        }

        return categoryService.nameAvailable(value)
    }
}