package ec.edu.sudamericano.practicasys.controller
import ec.edu.sudamericano.practicasys.model.*
import ec.edu.sudamericano.practicasys.service.CarreraService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/carreras")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class CarerraController {
    @Autowired
    lateinit var carreraService: CarreraService

    @GetMapping
    fun list(): List<Carrera>{
        return carreraService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Carrera? {
        return carreraService.listById(id)
    }



    @PostMapping
    fun save(@RequestBody carrera: Carrera):Carrera{
        return carreraService.save(carrera)
    }

    @PutMapping
    fun update(@RequestBody carrera: Carrera):Carrera{
        return carreraService.update(carrera)
    }


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean{
        return carreraService.delete(id)
    }
}