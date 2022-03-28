package br.com.dev.loja.service

import br.com.dev.loja.model.Categoria
import br.com.dev.loja.model.Produto
import org.springframework.http.ResponseEntity

interface ServiceProduct {

    fun addedNewProduct(produto: Produto) : ResponseEntity<Produto>

    // altera um produto existente
    fun changeProduct(produto: Produto)

    // retorna uma lista de todas produtos
    fun listProduct() : ArrayList<Produto>

    // retorna uma lista de produtos pela palavra chave
    fun productListWithKeyword(word: String): ArrayList<Produto>

    // retorna lista de produtos disponiveis
    fun availableProduct(): ArrayList<Produto>

    // retorna por categoria
    fun listByCategory(category: Categoria): ArrayList<Produto>

    fun listById(id: Long): Produto

 /*   fun listOfUnavailableProducts(): ArrayList<Produto>*/





}