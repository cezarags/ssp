package br.com.dev.loja.repository

import br.com.dev.loja.model.Cliente
import br.com.dev.loja.model.Pedido
import org.springframework.data.repository.CrudRepository

interface PedidoRepository: CrudRepository<Pedido, Long> {

    fun findAllByCliente(cliente: Cliente): ArrayList<Pedido>
}