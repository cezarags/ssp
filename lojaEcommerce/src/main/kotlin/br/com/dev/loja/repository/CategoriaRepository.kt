package br.com.dev.loja.repository

import br.com.dev.loja.model.Categoria
import org.springframework.data.repository.CrudRepository

interface CategoriaRepository: CrudRepository<Categoria, Long> {

    fun findByNomeContaining(word : String): ArrayList<Categoria>
}