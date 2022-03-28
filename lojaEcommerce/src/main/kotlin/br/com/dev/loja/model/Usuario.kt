package br.com.dev.loja.model

import javax.persistence.*

@Entity
@Table(name = "tbl_usuario")
data class Usuario (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    val id: Long,

    @Column(name="username", length = 45, nullable =  false, unique = true)
    val userName: String,

    @Column(name="password", length = 100, nullable =  false)
    val password: String,

    @Column(name="email",length = 50, nullable =  false, unique = true)
    val email: String?,

    @Column(name="nome_usuario", length = 50, nullable =  false)
    val nome_usuario: String?
        )