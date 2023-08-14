package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.model.*
import ec.edu.sudamericano.practicasys.repository.TeacherRepository
import ec.edu.sudamericano.practicasys.repository.TeacherViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TeacherService {
    @Autowired
    lateinit var teacherRepository: TeacherRepository
    @Autowired
    lateinit var teacherViewRepository: TeacherViewRepository

    fun list(): List<Teacher> {

        return teacherRepository.findAll()
    }
    fun listById (id:Long?): Teacher?{
        return teacherRepository.findById(id)
    }

    fun listTeacher (): List<TeacherView>{
        return teacherViewRepository.findAll()
    }

    fun save(teacher:Teacher):Teacher{
        teacher.apply {
            teStatus=true
        }
        return teacherRepository.save(teacher)
    }
    fun update(teacher:Teacher): Teacher {
        val response =teacherRepository.findById(teacher.id)
        if (response==null){
            throw Exception()
        }else{
            return teacherRepository.save(teacher)
        }
    }

    fun delete(id:Long):Boolean{
        teacherRepository.deleteById(id)
        return true
    }
}


