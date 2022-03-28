package br.com.dev.loja.service.impl

import br.com.dev.loja.model.Usuario
import br.com.dev.loja.repository.UsuarioRepository
import br.com.dev.loja.service.ServiceUsuario
import org.springframework.stereotype.Service

@Service
class ServiceUsuarioImpl(private val usuarioRepository: UsuarioRepository): ServiceUsuario {

    override fun findByUser(user: Usuario): Usuario{
        return usuarioRepository.findByUserNameOrEmail(user.userName, user.email)


    }
}