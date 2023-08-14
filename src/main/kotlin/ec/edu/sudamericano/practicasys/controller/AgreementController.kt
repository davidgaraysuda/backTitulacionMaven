package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.*
import ec.edu.sudamericano.practicasys.model.Agreement
import ec.edu.sudamericano.practicasys.model.AgreementView
import ec.edu.sudamericano.practicasys.model.AgreementViewCurrent
import ec.edu.sudamericano.practicasys.model.AgreementViewExpired
import ec.edu.sudamericano.practicasys.model.dto.AgreementReportsDto
import ec.edu.sudamericano.practicasys.service.AgreementService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/agreement")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class AgreementController {
    @Autowired
    lateinit var agreementService: AgreementService

    @GetMapping
    fun list(): List<Agreement>{
        return agreementService.list()
    }

    @GetMapping("/full")
    fun listFull(): List<AgreementView>{
        return agreementService.listFull()
    }

    @GetMapping("/current")
    fun listCurrent(): List<AgreementViewCurrent>{
        return agreementService.listCurrent()
    }

    @GetMapping("/expired")
    fun listExpired(): List<AgreementViewExpired>{
        return agreementService.listExpired()
    }

    @GetMapping("/reports")
    fun reportsAgreement(): AgreementReportsDto{
        return agreementService.reportsAgreement()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Agreement?{
        return agreementService.listById(id)
    }


    @PostMapping
    fun save(@RequestBody agreement: Agreement):Agreement{
        return agreementService.save(agreement)
    }

    @PutMapping
    fun update(@RequestBody agreement: Agreement):Agreement{
        return agreementService.update(agreement)
    }


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean{
        return agreementService.delete(id)
    }
}