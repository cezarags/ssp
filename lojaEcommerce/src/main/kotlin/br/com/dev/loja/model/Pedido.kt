package br.com.dev.loja.model


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate

import javax.persistence.*
import javax.persistence.CascadeType.ALL

@Entity
@Table(name = "tbl_pedido")
data class Pedido (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    val idpedido : Long,

    @Column(name = "data_pedido")
    val dataPedido: LocalDate,

    @Column(name = "valor_total")
    val valorTotal: Double,

    @Column(name = "observacoes")
    val observacoes: String,

    @Column(name = "status")
    val status: Int,

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    val cliente: Cliente,

    @OneToMany(mappedBy = "pedido", cascade = [ALL])
    @JsonIgnoreProperties("pedido")
    val itensPedido: List<ItemPedido>?

    )