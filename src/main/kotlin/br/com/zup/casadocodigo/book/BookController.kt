package br.com.zup.casadocodigo.book

import br.com.zup.casadocodigo.author.Author
import br.com.zup.casadocodigo.author.AuthorService
import br.com.zup.casadocodigo.category.CategoryModel
import br.com.zup.casadocodigo.category.CategoryService
import br.com.zup.casadocodigo.extension.toBookModel
import br.com.zup.casadocodigo.extension.toBookResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService,
                     private val categoryService: CategoryService,
                     private val authorService: AuthorService
) {

    @PostMapping
    fun create(@RequestBody @Valid bookRequest: BookRequest){

        val author = authorService.getAuthorId(bookRequest.authorId)
        val category = categoryService.getCategoryId(bookRequest.categoryId)

        bookService.create(bookRequest.toBookModel(category,author))
    }

    @GetMapping
    fun getAllBooks(): List<BookResponse>{
        return bookService.getAllBooks().map { it.toBookResponse() }
    }

    @GetMapping("/{id}")
    fun getIdBook(@PathVariable id: Int): BookResponse{
        return bookService.getIdBook(id).toBookResponse()
    }
}