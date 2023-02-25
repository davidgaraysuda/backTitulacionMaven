package com.example.securitykt.controller

import com.example.securitykt.model.Customer
import com.example.securitykt.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])

class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping
    fun list():List<Customer>{
        return customerService.list()
    }

    @PostMapping
    fun save(@RequestBody customer: Customer): Customer?{
        return customerService.save(customer)

    }

    @PutMapping
    fun update(@RequestBody customer:Customer): ResponseEntity<Customer> {
       return ResponseEntity (customerService.update(customer),HttpStatus.OK)
    }

    @PatchMapping
    fun updateName(@RequestBody customer:Customer): ResponseEntity<Customer> {
        return ResponseEntity(customerService.updateName(customer), HttpStatus.ACCEPTED)
    }

}