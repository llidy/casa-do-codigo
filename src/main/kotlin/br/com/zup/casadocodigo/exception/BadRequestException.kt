package br.com.zup.casadocodigo.exception

class BadRequestException(override val message: String, val errorCode: String): Exception() {

}
