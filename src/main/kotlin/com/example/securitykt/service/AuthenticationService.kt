package com.example.securitykt.service

import com.example.securitykt.dto.AuthenticationRequest
import com.example.securitykt.dto.AuthenticationResponse
import com.example.securitykt.dto.RegisterRequest
import com.example.securitykt.config.JwtService
import com.example.securitykt.model.User
import com.example.securitykt.repository.UserRepository
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
    @Autowired
    lateinit var authenticationManager: AuthenticationManager
    //private val authenticationManager: AuthenticationManager? = null

    fun register(request: RegisterRequest): AuthenticationResponse? {
        val user= User().apply {
            firstname= request.firstname
            lastname=request.lastname
            email=request.email
            password1= passwordEncoder?.encode(request.password)
            role= request.role

        }

        repository.save(user)
        val jwtToken = jwtService.generateToken(user,user.role)
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
        val jwtToken: String? = user?.let { jwtService.generateToken(it,user.role) }
        return AuthenticationResponse().apply {
            token=jwtToken
        }
    }
}