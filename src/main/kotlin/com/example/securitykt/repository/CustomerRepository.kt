package com.example.securitykt.repository

import com.example.securitykt.model.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CustomerRepository:JpaRepository<Customer, Long> {
    fun findById(id: Long?): Customer?
}
