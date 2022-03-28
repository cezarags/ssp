package br.com.dev.loja.service.impl

import br.com.dev.loja.model.ItemPedido
import br.com.dev.loja.model.Pedido
import br.com.dev.loja.repository.PedidoRepository
import br.com.dev.loja.service.ServicePedido
import org.springframework.stereotype.Service

@Service
class ServicePedidoImpl(
    private val pedidoRepository: PedidoRepository
):ServicePedido {

    override fun inserirPedido(novo: Pedido): Pedido? {
        try {
                for (item: ItemPedido in novo.itensPedido!!){
                    item.pedido = novo
                    item.precoUnitario = item.produto!!.preco
                    item.precoTotal = item.precoUnitario!! * item.qtdeItem!!
                }
                val pedido = pedidoRepository.save(novo)

                return pedido

        } catch (ex: Exception) {
            return null
        }
    }
}