package br.com.dev.loja.domain.rest

import br.com.dev.loja.model.Usuario
import br.com.dev.loja.security.JWTToken
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/login")
interface UsuarioApi {

    @PostMapping
    fun getToken(@RequestBody dadoLogin: Usuario): ResponseEntity<JWTToken>
}