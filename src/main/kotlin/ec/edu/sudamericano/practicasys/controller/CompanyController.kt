package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.model.Company
import ec.edu.sudamericano.practicasys.model.CompanyView
import ec.edu.sudamericano.practicasys.service.CompanyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.DeleteMapping


@RestController

@RequestMapping("/company")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class CompanyController {
    @Autowired
    lateinit var companyService: CompanyService

    @GetMapping
    fun list(): List<Company>{
        return companyService.list()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Company?{
        return companyService.listById(id)
    }

    @GetMapping("/with/tutor")
    fun listCompany(): List<CompanyView>{
        return companyService.listCompany()
    }

    @PostMapping
    fun save(@RequestBody company:Company):Company{
        return companyService.save(company)
    }

    @PutMapping
    fun update(@RequestBody company: Company): Company {
        return companyService.save(company)
    }


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean{
        return companyService.delete(id)
    }
}