package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.SpecificView
import org.springframework.data.jpa.repository.JpaRepository

interface SpecificViewRepository: JpaRepository<SpecificView, Long?> {
    fun findById(id: Long?): SpecificView?


}