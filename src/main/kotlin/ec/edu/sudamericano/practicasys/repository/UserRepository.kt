package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository:JpaRepository<User, Long?> {
    fun findByEmail(email: String?): User
}