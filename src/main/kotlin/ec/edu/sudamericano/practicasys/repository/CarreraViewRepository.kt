package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.CarreraView
import org.springframework.data.jpa.repository.JpaRepository


interface CarreraViewRepository: JpaRepository<CarreraView, Long?> {
    fun findById(id: Long?): CarreraView?
}