package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.Activity
import org.springframework.data.jpa.repository.JpaRepository

interface ActivityRepository: JpaRepository<Activity, Long?> {
    fun findById(id: Long?): Activity?
}