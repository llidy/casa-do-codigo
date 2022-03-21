package br.com.zup.casadocodigo.exception

import br.com.zup.casadocodigo.exception.Errors.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            ML001.message,
            ML001.code,
             ex.bindingResult.fieldErrors.map { FieldErrosResponse(it.defaultMessage ?: "invalid", it.field) }
        )
        return  ResponseEntity(error, HttpStatus.UNPROCESSABLE_ENTITY )
    }

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(ex: BadRequestException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return  ResponseEntity(error, HttpStatus.BAD_REQUEST )
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(ex: NotFoundException, request: WebRequest): ResponseEntity<ErrorResponse> {
        val error =  ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            ex.errorCode,
            null
        )
        return  ResponseEntity(error, HttpStatus.NOT_FOUND )
    }
}