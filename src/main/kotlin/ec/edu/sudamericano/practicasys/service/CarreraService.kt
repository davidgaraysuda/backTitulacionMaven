package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.model.*
import ec.edu.sudamericano.practicasys.repository.CarreraRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarreraService {
    @Autowired
    lateinit var carreraRepository: CarreraRepository



    fun list(): List<Carrera> {
        return carreraRepository.findAll()
        //return carreraRepository.findAll()
    }
    fun listById (id:Long?): Carrera?{
        return carreraRepository.findById(id)
    }


    fun save(carrera: Carrera):Carrera{
        return carreraRepository.save(carrera)
    }

    fun update(carrera: Carrera):Carrera{
        val response =carreraRepository.findById(carrera.id)
        if (response==null){
            throw Exception()
        }else{
            return carreraRepository.save(carrera)
        }
    }

    fun delete(id:Long):Boolean{
        carreraRepository.deleteById(id)
        return true
    }
}


