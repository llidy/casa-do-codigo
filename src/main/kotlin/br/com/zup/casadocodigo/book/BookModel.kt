package br.com.zup.casadocodigo.book

import br.com.zup.casadocodigo.author.Author
import br.com.zup.casadocodigo.category.CategoryModel
import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.format.annotation.DateTimeFormat
import java.math.BigDecimal
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.persistence.*
import javax.validation.constraints.*

@Entity(name="book")
class BookModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,

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
    @JoinColumn(name = "categories_id")
    val category: CategoryModel,

    @ManyToOne
    @JoinColumn(name = "author_id")
    val author: Author
)