package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.StudentView
import org.springframework.data.jpa.repository.JpaRepository

interface StudentViewRepository: JpaRepository<StudentView, Long?> {
    fun findById(id: Long?): StudentView?
}