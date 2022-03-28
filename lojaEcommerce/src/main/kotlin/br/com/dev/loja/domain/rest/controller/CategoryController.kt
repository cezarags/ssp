package br.com.dev.loja.domain.rest.controller

import br.com.dev.loja.domain.rest.CategoriaApi
import br.com.dev.loja.model.Categoria
import br.com.dev.loja.service.impl.ServiceCategoriaImpl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController(private val serviceCategoriaImpl: ServiceCategoriaImpl): CategoriaApi {


    override fun addCategory(@RequestBody categoria: Categoria) : ResponseEntity<Categoria>{
       val categoryadd =  serviceCategoriaImpl.insertNewCategory(categoria)

        return  ResponseEntity.status(201).body(categoria)

    }

    override fun getAllCategorys(): ResponseEntity<List<Categoria>> {

        val response = serviceCategoriaImpl.listCategory()

        return ResponseEntity.ok().body(response)
    }

    override fun findCategory(word: String): ArrayList<Categoria> {

        return serviceCategoriaImpl.categoryListWithKeyword(word = word)
    }

    override fun updateCategory(categoria: Categoria) {

       val response = serviceCategoriaImpl.changeCategory(categoria)

    }


}