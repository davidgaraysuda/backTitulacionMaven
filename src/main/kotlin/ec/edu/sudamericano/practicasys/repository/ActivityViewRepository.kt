package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.ActivityView
import org.springframework.data.jpa.repository.JpaRepository

interface ActivityViewRepository: JpaRepository<ActivityView, Long?> {
    fun findById(id: Long?): ActivityView?

}