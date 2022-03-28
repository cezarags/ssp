package br.com.dev.loja.security.Utils

import br.com.dev.loja.model.Usuario
import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import java.security.Key
import java.util.*
import javax.servlet.http.HttpServletRequest

class JWTTokenUtil {
    val SECRET_KEY = "*H4ct3d123456789NturSsPWebSecurityToken2021"
    val EXPIRATION = 2 * 60 * 1000
    val TK_PREFIX = "Bearer"
    val HEADER_AUTH = "Authorization"

    fun generateToken(user: Usuario): String {
        val secretkey: Key = Keys.hmacShaKeyFor(SECRET_KEY.encodeToByteArray())
        val jwt = Jwts.builder()
            .setSubject(user.userName)
            .setIssuer("*H4ct3d")
            .setExpiration(Date(System.currentTimeMillis().plus(EXPIRATION)))
            .signWith(secretkey, SignatureAlgorithm.HS256)
            .compact()

        return "$TK_PREFIX $jwt"

    }

    fun isIssued(issuer: String): Boolean {
        return issuer == "*H4ct3d"
    }

    fun isSubjectValid(subject: String): Boolean {
        return subject != null && subject.isNotEmpty()
    }

    fun isExpirationValid(expiration: Date): Boolean {
        return expiration.after(Date(System.currentTimeMillis()))
    }

    fun getAuthentication(request: HttpServletRequest): Authentication? {
        var token: String = request.getHeader(HEADER_AUTH)
        token.replace(TK_PREFIX, "") // retira o Bearer

        val untrusted: Jwt<Header<*>, Claims> = Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
                .parseClaimsJwt(token)

        val username: String = untrusted.body.subject
        val emissor: String = untrusted.body.issuer
        val expira: Date = untrusted.body.expiration

        if (isSubjectValid(username) && isIssued(emissor) && isExpirationValid(expira)) {
            return UsernamePasswordAuthenticationToken(username, null, Collections.emptyList())
        }
        return null


    }
}


