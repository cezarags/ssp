package br.com.dev.loja.model

import java.awt.SystemColor.text
import javax.persistence.*

@Entity
@Table(name = "tbl_categoria")
data class Categoria (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    var id: Long,
    @Column(name = "nome_categoria", length = 100, unique = true )
    val nome: String,
        )