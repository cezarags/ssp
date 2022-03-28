package br.com.dev.loja.domain.rest.controller

import br.com.dev.loja.domain.rest.PedidoApi
import br.com.dev.loja.model.Pedido
import br.com.dev.loja.repository.PedidoRepository
import br.com.dev.loja.service.ServicePedido
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PedidoController(
    private val servicePedido: ServicePedido
): PedidoApi {
    override fun inserirNovoPedido(novo: Pedido): ResponseEntity<Pedido> {

        println("------Pedido------")
        println(novo.observacoes)
        println(novo.dataPedido)
        println(novo.itensPedido)

        val response = servicePedido.inserirPedido(novo)
        if (novo != null) {
            return ResponseEntity.ok(response)
        }else{
            return ResponseEntity.status(400).build()
        }
    }

}