package br.com.zup.casadocodigo.validation

import org.springframework.util.Assert
import javax.persistence.EntityManager
import javax.persistence.Query
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class UniqueValueValidator(private val manager: EntityManager): ConstraintValidator<UniqueValue, String> {

    lateinit var  domainAttribute: String
    lateinit var klass: KClass<*>


    override fun initialize(constraint: UniqueValue) {
        domainAttribute = constraint.fieldName
        klass = constraint.domainClass
    }


    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        var query: Query = manager.createQuery("select 1 from "+klass.qualifiedName+" where "+domainAttribute+"=:value");
        query.setParameter("value",value);
        var list: List<*> = query.resultList;
        Assert.isTrue(list.size <=1, "Foi encontado mais de um "+klass+" com o atributo "+domainAttribute+"= "+value)

        return list.isEmpty()

    }
}