package br.com.zup.casadocodigo.category

import br.com.zup.casadocodigo.validation.NameAvailable
import br.com.zup.casadocodigo.validation.UniqueValue
import javax.validation.constraints.NotEmpty

data class CategoryRequest(

    @UniqueValue(domainClass = CategoryModel::class, fieldName = "name", message = "Categoria já cadastrada")
    @NotEmpty
    val name: String
)
