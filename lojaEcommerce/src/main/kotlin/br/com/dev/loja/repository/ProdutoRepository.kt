package br.com.dev.loja.repository

import br.com.dev.loja.model.Categoria
import br.com.dev.loja.model.Produto
import org.springframework.data.repository.CrudRepository

interface ProdutoRepository: CrudRepository<Produto, Long> {

    fun findAllByDisponivel(disponivel: Boolean)
    fun findAllByDisponivelAndCategoria(disponivel: Boolean, categoria: Categoria)
    fun findByCategoria(categoria: Categoria): ArrayList<Produto>
}