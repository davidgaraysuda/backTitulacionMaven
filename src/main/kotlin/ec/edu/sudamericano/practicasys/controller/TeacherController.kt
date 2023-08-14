package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.model.*
import ec.edu.sudamericano.practicasys.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teachers")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class TeacherController {
    @Autowired
    lateinit var teacherService: TeacherService

    @GetMapping
    fun list(): List<Teacher>{
        return teacherService.list()
    }

    @GetMapping("/with/career")
    fun listTeacherFull (): List<TeacherView>{
        return teacherService.listTeacher()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Teacher?{
        return teacherService.listById(id)
    }


    @PostMapping
    fun save(@RequestBody teacher:Teacher):Teacher{
        return teacherService.save(teacher)
    }
    @PutMapping
    fun update(@RequestBody teacher:Teacher): Teacher {
        return teacherService.save(teacher)
    }


    @DeleteMapping("/delete/{id}")


    fun delete(@PathVariable("id") id:Long):Boolean{
        return teacherService.delete(id)
    }
}