package br.com.dev.loja.service

import br.com.dev.loja.model.Usuario
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
interface ServiceUsuario {

    fun findByUser(user: Usuario): Usuario
}