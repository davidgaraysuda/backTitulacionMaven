package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.SpecificViewCurrent
import org.springframework.data.jpa.repository.JpaRepository

interface SpecificViewCurrentRepository: JpaRepository<SpecificViewCurrent, Long?> {
    fun findById(id: Long?): SpecificViewCurrent?
    fun findByCareer(career: String?): List<SpecificViewCurrent>

}