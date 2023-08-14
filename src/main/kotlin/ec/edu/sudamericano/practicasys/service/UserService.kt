package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.model.User
import ec.edu.sudamericano.practicasys.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun list ():List<User>{
        return userRepository.findAll()
    }

    fun findByEmail (email:String):User{
        val response = userRepository.findByEmail(email)
        response.password=""
        return response
    }

    fun save (user: User):User {
        try {
            user.firstname?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("fullname no debe ser vacio")
            return userRepository.save(user)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun update(user: User):User{
        try {
            /*  userRepository.findById(user.email)
                  ?: throw Exception("El id ${user.id}")*/
            return userRepository.save(user)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun updateName(user: User):User{
        try{
//            val response = userRepository.findById(user.id)
//                ?:throw Exception("El id ${user.id} en usere no existe")
//            response.apply{
//                firstname = user.firstname
//            }
            return userRepository.save(user)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)

        }
    }

}