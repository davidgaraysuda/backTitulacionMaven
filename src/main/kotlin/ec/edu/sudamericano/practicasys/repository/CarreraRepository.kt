package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.Carrera
import org.springframework.data.jpa.repository.JpaRepository

interface CarreraRepository: JpaRepository<Carrera, Long?> {
    fun findById(id: Long?): Carrera?
}