package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.model.TeacherView
import ec.edu.sudamericano.practicasys.model.Tutor
import ec.edu.sudamericano.practicasys.model.TutorView
import ec.edu.sudamericano.practicasys.service.TutorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tutors")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class TutorController {
    @Autowired
    lateinit var tutorService: TutorService

    @GetMapping
    fun list(): List<Tutor>{
        return tutorService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Tutor?{
        return tutorService.listById(id)
    }

    @GetMapping("/with/company")
    fun listTutorFull (): List<TutorView>{
        return tutorService.listTutorFull()
    }

    @PostMapping
    fun save(@RequestBody tutor:Tutor):Tutor{
        return tutorService.save(tutor)
    }

    @PutMapping
    fun update(@RequestBody tutor: Tutor):Tutor{
        return tutorService.save(tutor)
    }


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean{
        return tutorService.delete(id)
    }
}