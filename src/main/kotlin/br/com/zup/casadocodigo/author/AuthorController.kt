package br.com.zup.casadocodigo.author

import br.com.zup.casadocodigo.extension.toAuthor
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/authors")
class AuthorController(private val authorService: AuthorService) {

    @PostMapping
    fun create(@RequestBody @Valid authorRequest: AuthorRequest){
        authorService.create(authorRequest.toAuthor())
    }

    @GetMapping("/{id}")
    fun getAuthorId(@PathVariable id: Int): Author{
        return authorService.getAuthorId(id)
    }
}