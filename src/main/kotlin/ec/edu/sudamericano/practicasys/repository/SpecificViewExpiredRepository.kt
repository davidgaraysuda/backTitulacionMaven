package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.SpecificViewExpired
import org.springframework.data.jpa.repository.JpaRepository

interface SpecificViewExpiredRepository: JpaRepository<SpecificViewExpired, Long?> {
    fun findById(id: Long?): SpecificViewExpired?


}