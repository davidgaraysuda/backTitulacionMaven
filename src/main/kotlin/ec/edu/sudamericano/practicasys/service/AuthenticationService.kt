package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.config.JwtService
import ec.edu.sudamericano.practicasys.dto.AuthenticationRequest
import ec.edu.sudamericano.practicasys.dto.AuthenticationResponse
import ec.edu.sudamericano.practicasys.model.UserAuth
import ec.edu.sudamericano.practicasys.model.dto.RegisterRequest
import ec.edu.sudamericano.practicasys.repository.UserAuthRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService {
    @Autowired
    lateinit var repository: UserAuthRepository

    //    private val repository: UserRepository? = null
    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Autowired
    lateinit var jwtService: JwtService

    //private val jwtService: JwtService? = null
    @Autowired
    lateinit var authenticationManager: AuthenticationManager
    //private val authenticationManager: AuthenticationManager? = null

    fun register(request: RegisterRequest): AuthenticationResponse? {
        val userAuth= UserAuth().apply {
            firstname= request.firstname
            lastname=request.lastname
            email=request.email
            password1= passwordEncoder?.encode(request.password)
            role= request.role

        }

        repository.save(userAuth)
        val jwtToken = jwtService.generateToken(userAuth,userAuth.role)
        return AuthenticationResponse().apply {
            token=jwtToken
        }

    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse? {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email,
                request.password
            )
        )
        val user = repository.findByEmail(request.email)?.orElseThrow()
        val jwtToken: String? = user?.let { jwtService.generateToken(it, user.role) }
        return AuthenticationResponse().apply {
            token = jwtToken
        }
    }
}