package br.com.zup.casadocodigo.book

import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<BookModel, Int> {

}
