package br.com.zup.casadocodigo.exception

class ErrorResponse(
    var httpCode: Int,
    var message: String,
    var internalCode: String,
    var errors: List<FieldErrosResponse>?
)