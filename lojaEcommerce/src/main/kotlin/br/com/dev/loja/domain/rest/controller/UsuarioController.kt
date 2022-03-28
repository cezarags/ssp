package br.com.dev.loja.domain.rest.controller

import br.com.dev.loja.domain.rest.UsuarioApi
import br.com.dev.loja.model.Usuario
import br.com.dev.loja.security.JWTToken
import br.com.dev.loja.security.Utils.JWTTokenUtil
import br.com.dev.loja.service.ServiceUsuario
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UsuarioController(
    private val serviceUsuario: ServiceUsuario) : UsuarioApi {

    override fun getToken(dadosLogin: Usuario): ResponseEntity<JWTToken> {
        var user: Usuario = serviceUsuario.findByUser(dadosLogin)

        if (user != null){
            if(user.password.equals(dadosLogin.password)){
                var jwtToken: JWTToken = JWTToken()
                jwtToken.token = JWTTokenUtil().generateToken(user)
                return ResponseEntity.ok(jwtToken)
            }
            return ResponseEntity.status(403).build()

        }
        return  ResponseEntity.notFound().build()
    }


}

