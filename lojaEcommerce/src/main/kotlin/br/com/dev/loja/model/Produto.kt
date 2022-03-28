package br.com.dev.loja.model


import javax.persistence.*

@Entity
@Table(name="tbl_produto")
data class Produto (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    val id: Long,

    @Column(name = "nome_produto", length = 15, nullable = false)
    val nome: String?,

    @Column(name = "detalhe_produto", length = 150, nullable = false)
    val detalhe: String?,

    @Column(name = "link_produto", length= 200, nullable = false)
    val linkFoto: String?,

    @Column(name = "preco_produto", nullable = false)
    val preco: Double?,

    @Column(name = "disponivel")
    val disponivel: Boolean?,

    @ManyToOne
    @JoinColumn(name="id_categoriaFK" )
    val categoria: Categoria?
        )