package br.com.dev.loja.security

import br.com.dev.loja.security.Utils.JWTTokenUtil
import org.apache.tomcat.util.http.parser.Authorization
import org.springframework.boot.actuate.endpoint.SecurityContext
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenFilter(): OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain // verifica a autorização
    ) {

        // Requisições que nao precisam de autenticação, não levam em conta o token no cabeçalho
        // Quando precisar se o token for valido encaminha o mesmo para autorização

        println("Requisição passou pelo filtro")

        // se for diferente de null
        if(request.getHeader("Authorization") != null){

            // SE TIVER UM CABEÇALHO COM TOKEN DECODIFICA
            val auth = JWTTokenUtil()
            auth.getAuthentication(request)

            // SE FOR VALIDO VAI PARA O CONTEXTO DA REQUISIÇÃO  UM PBJETO QUE REPRESENTA O TOKEN
            SecurityContextHolder.getContext().authentication
        }// FILTRO DO AUTH
       filterChain.doFilter(request, response)
    }
}