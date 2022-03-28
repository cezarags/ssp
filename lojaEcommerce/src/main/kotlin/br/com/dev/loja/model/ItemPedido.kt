package br.com.dev.loja.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name="tbl_itempedido")
data class ItemPedido (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seq")
    val numSeq: Long,

    @Column(name= "qtde_item")
    val qtdeItem: Int?,

    @Column(name = "preco_unitario")
    var precoUnitario: Double?,

    @Column(name = "preco_total")
    var precoTotal: Double?,

    @ManyToOne
    @JoinColumn(name = "id_pedido_fk")
    @JsonIgnoreProperties("itensPedido")
    var pedido: Pedido?,

    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    val produto: Produto?
    )

{
    override fun toString(): String {
        return "ItemPedido(numSeq=$numSeq, qtdeItem=$qtdeItem, precoUnitario=$precoUnitario, precoTotal=$precoTotal, pedido=$pedido, produto=$produto)"
    }
}