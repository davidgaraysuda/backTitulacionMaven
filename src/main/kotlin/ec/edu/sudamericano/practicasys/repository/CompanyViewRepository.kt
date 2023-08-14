package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.CompanyView
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyViewRepository: JpaRepository<CompanyView, Long?> {
    fun findById(id: Long?): CompanyView?
}