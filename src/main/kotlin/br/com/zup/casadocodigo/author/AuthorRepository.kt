package br.com.zup.casadocodigo.author

import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository: JpaRepository<Author, Int> {
    fun existsByEmail(email: String): Boolean

}
