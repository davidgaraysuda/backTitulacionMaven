package com.example.securitykt.repository

import com.example.securitykt.model.UserAuth
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserAuthRepository : JpaRepository<UserAuth,Long?> {
    fun findByEmail(email: String?): Optional<UserAuth?>?
}