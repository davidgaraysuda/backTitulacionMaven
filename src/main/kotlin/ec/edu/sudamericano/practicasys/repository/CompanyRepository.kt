package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository: JpaRepository<Company, Long?> {
    fun findById(id: Long?): Company?
}