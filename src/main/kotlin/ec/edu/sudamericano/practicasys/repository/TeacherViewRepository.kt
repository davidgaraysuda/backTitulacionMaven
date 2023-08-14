package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.TeacherView
import org.springframework.data.jpa.repository.JpaRepository

interface TeacherViewRepository: JpaRepository<TeacherView, Long?> {
    fun findById(id: Long?): TeacherView?
}