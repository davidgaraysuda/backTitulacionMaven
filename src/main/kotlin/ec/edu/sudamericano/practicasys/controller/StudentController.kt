package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.dto.DatosReporteDto
import ec.edu.sudamericano.practicasys.model.*
import ec.edu.sudamericano.practicasys.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/students")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class StudentController {
    @Autowired
    lateinit var studentService: StudentService

    @GetMapping
    fun list(): List<Student> {
        return studentService.list()
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): Student? {
        return studentService.listById(id)
    }
    @GetMapping("/with/carrera")
    fun listCarrera(): List<StudentView>{
        return studentService.listByEstudiante()
    }


    @PostMapping
    fun save(@RequestBody student: Student): Student {
        return studentService.save(student)
    }

    @PutMapping
    fun update(@RequestBody student: Student): Student {
        return studentService.update(student)
    }


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean {
        return studentService.delete(id)
    }

    @GetMapping("/{idStudent}/{idTutor}")
    fun cargarReporte(@PathVariable("idStudent") idStudent: Long, @PathVariable("idTutor") idTutor: Long): DatosReporteDto? {
        return studentService.datosReporte(idStudent, idTutor)
    }
}