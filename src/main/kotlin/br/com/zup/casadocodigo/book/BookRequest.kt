package br.com.zup.casadocodigo.book

import br.com.zup.casadocodigo.author.Author
import br.com.zup.casadocodigo.category.CategoryModel
import br.com.zup.casadocodigo.validation.UniqueValue
import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.*

data class BookRequest (

    @UniqueValue(domainClass = BookModel::class, fieldName = "title", message = "Título já cadastrado" )
    @field:NotEmpty
    val title: String,

    @field:NotEmpty
    @field:Size(max=500)
    val resume: String,

    @field:NotEmpty
    val summary: String,

    @field:NotNull
    @field:DecimalMin("20.00")
    val price: BigDecimal,

    @field:Min(100)
    val numberOfPages: Int,

    @field:NotEmpty
    val bookIdentifier: String,

    @field:Future
    @field:NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    var dateAt: LocalDate,

    @ManyToOne
    @JsonAlias("categories_id")
    val categoryId: Int,

    @ManyToOne
    @JsonAlias("author_id")
    val authorId: Int
)
