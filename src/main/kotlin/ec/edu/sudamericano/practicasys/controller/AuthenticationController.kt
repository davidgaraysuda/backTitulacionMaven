package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.dto.AuthenticationRequest
import ec.edu.sudamericano.practicasys.dto.AuthenticationResponse
import ec.edu.sudamericano.practicasys.model.dto.RegisterRequest
import ec.edu.sudamericano.practicasys.service.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class AuthenticationController {
    @Autowired
    lateinit var service: AuthenticationService

    @PostMapping("/register")
    fun register(
        @RequestBody request: RegisterRequest
    ): ResponseEntity<AuthenticationResponse?>? {
        return ResponseEntity.ok(service.register(request))
    }

    @PostMapping("/authenticate")
    fun authenticate(
        @RequestBody request: AuthenticationRequest
    ): ResponseEntity<AuthenticationResponse?>? {
        return ResponseEntity.ok(service.authenticate(request))
    }

}