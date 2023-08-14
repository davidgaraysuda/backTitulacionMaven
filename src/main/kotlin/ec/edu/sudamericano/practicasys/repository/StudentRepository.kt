package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository: JpaRepository<Student, Long?> {
    fun findById(id: Long?): Student?


}