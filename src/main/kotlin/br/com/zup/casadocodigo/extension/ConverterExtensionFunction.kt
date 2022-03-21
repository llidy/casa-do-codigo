package br.com.zup.casadocodigo.extension

import br.com.zup.casadocodigo.author.Author
import br.com.zup.casadocodigo.author.AuthorRequest
import br.com.zup.casadocodigo.book.BookModel
import br.com.zup.casadocodigo.book.BookRequest
import br.com.zup.casadocodigo.book.BookResponse
import br.com.zup.casadocodigo.category.CategoryModel
import br.com.zup.casadocodigo.category.CategoryRequest
import br.com.zup.casadocodigo.country.CountryModel
import br.com.zup.casadocodigo.country.CountryRequest
import br.com.zup.casadocodigo.country.StateModel
import br.com.zup.casadocodigo.country.StateRequest

fun AuthorRequest.toAuthor(): Author{
    return Author(
        name = name,
        email = email,
        description = description,

    )
}

fun CategoryRequest.toCategoryModel(): CategoryModel{
    return CategoryModel(
        name = name
    )
}

fun BookRequest.toBookModel(category: CategoryModel, author: Author): BookModel{
    return BookModel(

        title = title,
        resume = resume,
        summary = summary,
        price = price,
        numberOfPages = numberOfPages,
        bookIdentifier = bookIdentifier,
        dateAt = dateAt,
        category = category,
        author = author

    )
}

fun BookModel.toBookResponse(): BookResponse{
    return BookResponse(
        title = title,
        resume = resume,
        summary = summary,
        price = price,
        numberOfPages = numberOfPages,
        bookIdentifier = bookIdentifier,
        dateAt = dateAt,
        category = category,
        author = author
    )
}

fun CountryRequest.toCountryModel(): CountryModel{
    return CountryModel(
        name = name
    )
}


fun StateRequest.toStateModel(countryModel: CountryModel): StateModel{
    return StateModel(
        name = name,
        countryModel = countryModel
    )
}