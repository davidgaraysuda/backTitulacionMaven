package com.example.securitykt.service

import com.example.securitykt.model.Customer
import com.example.securitykt.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException



@Service
class CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    fun list ():List<Customer>{
        return customerRepository.findAll()
    }

    fun save (customer: Customer):Customer {
        try {
            customer.firstname?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("fullname no debe ser vacio")
            return customerRepository.save(customer)
        } catch (ex: Exception) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)
        }
    }
    fun update(client: Customer):Customer{
        try {
            customerRepository.findById(client.id)
                ?: throw Exception("El id ${client.id}")
            return customerRepository.save(client)
        }
        catch(ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }


    fun updateName(customer: Customer):Customer{
        try{
            val response = customerRepository.findById(customer.id)
                ?:throw Exception("El id ${customer.id} en cliente no existe")
            response.apply{
                firstname = customer.firstname
            }
            return customerRepository.save(response)
        }
        catch (ex:Exception){
            throw  ResponseStatusException(HttpStatus.NOT_FOUND, ex.message)

        }
    }


}