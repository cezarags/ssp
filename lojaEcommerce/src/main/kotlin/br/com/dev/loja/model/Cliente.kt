package br.com.dev.loja.model


import javax.persistence.*

@Entity
@Table(name = "tbl_cliente")
data class Cliente (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    val idCliente: Long,

    @Column(name = "nome_cliente", length =100, nullable = false, unique = false)
    val nome: String?,

    @Column(name="email_cliente", length = 100, nullable = false, unique = true)
    val email: String?,

    @Column(name="telefone_cliente", length=20, nullable = false, unique = true)
    val telefone: String?,

    @Column(name = "cep_cliente", length = 100, nullable = false)
    val cep: String?,

    @Column(name = "logradouro", length=100, )
    val logradouro: String?,

    @Column(name = "numero", length = 10)
    val numero: String?,

    @Column(name = "complemento", length = 50)
    val complemento: String?,

    @Column(name = "bairro", length = 100)
    val bairro: String?,

    @Column(name = "cidade", length = 100)
    val cidade: String?,

    @Column(name = "estado", length = 2)
    val estado: String?
    )