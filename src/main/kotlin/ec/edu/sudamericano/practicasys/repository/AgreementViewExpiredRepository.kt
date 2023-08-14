package ec.edu.sudamericano.practicasys.repository


import ec.edu.sudamericano.practicasys.model.AgreementViewExpired
import org.springframework.data.jpa.repository.JpaRepository

interface AgreementViewExpiredRepository: JpaRepository<AgreementViewExpired, Long?> {
    fun findById(id: Long?): AgreementViewExpired?
}