package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.model.User
import ec.edu.sudamericano.practicasys.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun list():List<User>{
        return userService.list()
    }

    @GetMapping("/find-email/{email}")
    fun findByEmail(@PathVariable email: String ):User{
        return userService.findByEmail(email)
    }

    @PostMapping
    fun save(@RequestBody user: User): User?{
        return userService.save(user)

    }

    @PutMapping
    fun update(@RequestBody user:User): ResponseEntity<User> {
        return ResponseEntity (userService.update(user), HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody user:User): ResponseEntity<User> {
        return ResponseEntity(userService.updateName(user), HttpStatus.ACCEPTED)
    }

}