package br.com.dev.loja.repository

import br.com.dev.loja.model.Cliente
import org.springframework.data.repository.CrudRepository

interface ClienteRespository: CrudRepository<Cliente, Long>{

    fun findByEmailOrTelefone(email: String, telefone: String): Cliente
}