package br.com.zup.casadocodigo.category

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository: JpaRepository<CategoryModel, Int> {
    fun existsByName(name: String): Boolean

}
