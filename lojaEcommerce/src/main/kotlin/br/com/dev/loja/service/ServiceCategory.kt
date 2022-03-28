package br.com.dev.loja.service

import br.com.dev.loja.model.Categoria
import java.util.*
import kotlin.collections.ArrayList


interface ServiceCategory {


    // recebe a categoria só com nome preenchido e vai inserir no baco
    fun insertNewCategory(category: Categoria)

    // altera uma categoria existe
    fun changeCategory(category: Categoria)

    // retorna uma lista de todas categorias
    fun listCategory() : List<Categoria>

    // retorna uma lista de categorias pela palavra chave
    fun categoryListWithKeyword(word: String): ArrayList<Categoria>



}