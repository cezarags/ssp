package br.com.dev.loja.service.impl
import br.com.dev.loja.model.Categoria
import br.com.dev.loja.repository.CategoriaRepository
import br.com.dev.loja.service.ServiceCategory
import org.hibernate.annotations.common.util.impl.LoggerFactory.logger


import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.ArrayList


@Component
class ServiceCategoriaImpl(private val categoryRepository: CategoriaRepository) : ServiceCategory {

    private val log = logger(ServiceCategoriaImpl::class.java)

    override fun insertNewCategory(category: Categoria) {
        runCatching {
            category.nome.isNotEmpty() && category.nome != ""

        }.onSuccess {
            categoryRepository.save(category)
            log.info("Added category with sucess: {${category.nome}}")

        }.onFailure {
            throw IllegalArgumentException()
        }
    }

    override fun changeCategory(category: Categoria) {
        categoryRepository.save(category)
        log.info("update category with sucess: {${category.nome}}")
    }

    override fun listCategory(): List<Categoria> {
        val reponseAll = categoryRepository.findAll()
        log.info("Return all Categories")
        return reponseAll.toList()

    }

    override fun categoryListWithKeyword(word: String): ArrayList<Categoria> {
        kotlin.runCatching {
            word.isNotEmpty() && word != null

        }.onSuccess {
            categoryRepository.findByNomeContaining(word)
        }.onFailure {
            throw Exception()
        }

        return categoryRepository.findByNomeContaining(word)
    }




}

