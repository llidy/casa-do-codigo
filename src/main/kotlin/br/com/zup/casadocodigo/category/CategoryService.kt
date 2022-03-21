package br.com.zup.casadocodigo.category

import br.com.zup.casadocodigo.book.BookModel
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun create(categoryModel: CategoryModel) {
        categoryRepository.save(categoryModel)
    }

    fun nameAvailable(name: String): Boolean {
       return !categoryRepository.existsByName(name)
    }

    fun getCategoryId(id: Int): CategoryModel {
        return categoryRepository.findById(id).orElseThrow()
    }

}
