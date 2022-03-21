package br.com.zup.casadocodigo.category

import br.com.zup.casadocodigo.book.BookModel
import br.com.zup.casadocodigo.extension.toCategoryModel
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/categories")
class CategoryController(private val serviceCategory: CategoryService) {

    @PostMapping
    fun create(@RequestBody @Valid categoryRequest: CategoryRequest){
        serviceCategory.create(categoryRequest.toCategoryModel())
    }

    @GetMapping("/{id}")
    fun getCategoryId(@PathVariable id: Int) {
        serviceCategory.getCategoryId(id)
    }
}