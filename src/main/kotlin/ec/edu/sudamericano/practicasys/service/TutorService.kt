package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.model.Tutor
import ec.edu.sudamericano.practicasys.model.TutorView
import ec.edu.sudamericano.practicasys.repository.TutorRepository
import ec.edu.sudamericano.practicasys.repository.TutorViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class   TutorService {
    @Autowired
    lateinit var tutorRepository: TutorRepository

    @Autowired
    lateinit var tutorViewRepository: TutorViewRepository


    fun list(): List<Tutor> {
        return tutorRepository.findAll()
    }

    fun listById (id:Long?): Tutor?{
        return tutorRepository.findById(id)
    }

    fun listTutorFull (): List<TutorView>{
        return tutorViewRepository.findAll()
    }

    fun save(tutor:Tutor):Tutor{
        try {
            //validar si campos vienen vacios
            tutor.name?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Nombre no debe ser vacio")

            tutor.apply {
                tuStatus=true
            }
            return tutorRepository.save(tutor)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }

    fun update(tutor: Tutor):Tutor{
        try {
            //Validar que tutor exista para actualizar
            val response =tutorRepository.findById(tutor.id)
                    ?: throw Exception("El id ${tutor.id} de tutor no existe")

            // Validar todos los campos necesarios ........

            //validar si campos vienen vacios
            tutor.name?.takeIf { it.trim().isNotEmpty() }
                    ?: throw Exception("Nombre no debe ser vacio")

            //Actualizar valores actuales (response) con nuevos (tutor)
            response.apply {
                name=tutor.name
                phone = tutor.phone
                alternative=tutor.alternative
                tuStatus=tutor.tuStatus
            }
            return tutorRepository.save(tutor)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun delete(id:Long):Boolean{
        tutorRepository.deleteById(id)
        return true
    }
}


