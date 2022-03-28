package br.com.dev.loja.service

import br.com.dev.loja.model.Pedido

interface ServicePedido {

    fun inserirPedido(novo: Pedido): Pedido?
}

