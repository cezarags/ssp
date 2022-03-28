package br.com.dev.loja.repository

import br.com.dev.loja.model.Usuario
import org.springframework.data.repository.CrudRepository

interface UsuarioRepository: CrudRepository<Usuario, Long> {

    fun findByUserNameOrEmail(username: String, email: String?): Usuario
}