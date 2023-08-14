package ec.edu.sudamericano.practicasys.repository


import ec.edu.sudamericano.practicasys.model.AgreementView
import org.springframework.data.jpa.repository.JpaRepository

interface AgreementViewRepository: JpaRepository<AgreementView, Long?> {
    fun findById(id: Long?): AgreementView?
}