package br.com.zup.casadocodigo.book

import br.com.zup.casadocodigo.author.Author
import br.com.zup.casadocodigo.category.CategoryModel
import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.*

data class BookResponse (

    val id: Int? = null,

    val title: String,

    val resume: String,

    val summary: String,

    val price: BigDecimal,

    val numberOfPages: Int,

    val bookIdentifier: String,

    var dateAt: LocalDate,

    val category: CategoryModel,

    val author: Author
        )
