package br.com.zup.casadocodigo.exception


enum class Errors(val code: String, val message: String) {

    Ml000("ML-000", "Access Denied"),

    ML001("ML-001","Invalid Request"),

    ML100("ML-0001", "Book {[%s]} not exists"),
    ML101("ML-0002", "Cannot update book with status[%s]"),

    ML200("ML-0002", "Book [%s] not exists")
}