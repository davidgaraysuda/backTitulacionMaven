package com.example.securitykt.auth

import com.example.securitykt.config.JwtService
import com.example.securitykt.user.Role
import com.example.securitykt.user.User
import com.example.securitykt.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService {
    @Autowired
    lateinit var repository: UserRepository
//    private val repository: UserRepository? = null
@Autowired
    private val passwordEncoder: PasswordEncoder? = null
    @Autowired
    lateinit var jwtService: JwtService
    //private val jwtService: JwtService? = null
    private val authenticationManager: AuthenticationManager? = null

    fun register(request: RegisterRequest): AuthenticationResponse? {
        val user= User().apply {
            firstname= request.firstname
            lastname=request.lastname
            email=request.email
            password1= passwordEncoder?.encode(request.password)
            role= Role.USER

        }

        repository?.save(user)
        val jwtToken = jwtService?.generateToken(user)
        return AuthenticationResponse().apply {
            token=jwtToken
        }

    }

    fun authenticate(request: AuthenticationRequest): AuthenticationResponse? {
        authenticationManager!!.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email,
                request.password
            )
        )
        val user = repository?.findByEmail(request.email)?.orElseThrow()
        val jwtToken: String? = user?.let { jwtService?.generateToken(it) }
        return AuthenticationResponse().apply {
            token=jwtToken
        }
    }
}