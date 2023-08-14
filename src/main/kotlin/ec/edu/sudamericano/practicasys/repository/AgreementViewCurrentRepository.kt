package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.AgreementViewCurrent
import org.springframework.data.jpa.repository.JpaRepository

interface AgreementViewCurrentRepository: JpaRepository<AgreementViewCurrent, Long?> {
    fun findById(id: Long?): AgreementViewCurrent?
}