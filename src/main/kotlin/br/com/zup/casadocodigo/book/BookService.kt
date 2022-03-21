package br.com.zup.casadocodigo.book

import br.com.zup.casadocodigo.exception.BadRequestException
import br.com.zup.casadocodigo.exception.Errors
import br.com.zup.casadocodigo.exception.NotFoundException
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {
    fun create(bookModel: BookModel) {
        bookRepository.save(bookModel)

    }

    fun getAllBooks(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun getIdBook(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow{NotFoundException(Errors.ML200.message.format(id), Errors.ML200.code)}
    }


}
