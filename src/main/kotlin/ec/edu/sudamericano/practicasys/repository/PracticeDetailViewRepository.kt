package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.PracticeDetailView
import org.springframework.data.jpa.repository.JpaRepository

interface PracticeDetailViewRepository: JpaRepository<PracticeDetailView, Long?> {
    fun findById(id: Long?): PracticeDetailView?

}