package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.UserAuth
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserAuthRepository: JpaRepository<UserAuth, Long?>{

    fun findByEmail(email: String?): Optional<UserAuth?>?
}