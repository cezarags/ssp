package br.com.dev.loja.domain.rest

import br.com.dev.loja.model.Pedido
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/pedido")
@RestController
interface PedidoApi {

    @PostMapping("/inserir")
    fun inserirNovoPedido(@RequestBody novo: Pedido): ResponseEntity<Pedido>


}