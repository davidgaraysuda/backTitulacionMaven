package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.Teacher
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherRepository: JpaRepository<Teacher, Long?> {
    fun findById(id: Long?): Teacher?
}