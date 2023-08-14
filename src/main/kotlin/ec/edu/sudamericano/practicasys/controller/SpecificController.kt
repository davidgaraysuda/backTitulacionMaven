package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.model.*
import ec.edu.sudamericano.practicasys.model.dto.AgreementReportsDto
import ec.edu.sudamericano.practicasys.model.dto.SpecificReportsDto
import ec.edu.sudamericano.practicasys.service.SpecificService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/specifics")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class SpecificController {
    @Autowired
    lateinit var specificService: SpecificService

    @GetMapping
    fun list(): List<Specific>{
        return specificService.list()
    }

    @GetMapping("/list")
    fun listSpecificFull (): List<SpecificView>{
        return specificService.listSpecific()
    }

    @GetMapping("/current")
    fun listSpecificCurrent (): List<SpecificViewCurrent>{
        return specificService.listSpecificCurrent()
    }

    @GetMapping("/expired")
    fun listSpecificExpired (): List<SpecificViewExpired>{
        return specificService.listSpecificExpired()
    }
    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Specific?{
        return specificService.listById(id)
    }

    @GetMapping("/current/{career}")
    fun listByCareer (@PathVariable("career") career: String?): List<SpecificViewCurrent>{
        return specificService.listByCareer(career)
    }

    @GetMapping("/reports/software")
    fun reportsSoftware(): SpecificReportsDto {
        return specificService.reportsSpecificSoftware()
    }

    @GetMapping("/reports/desing")
    fun reportsDesing(): SpecificReportsDto {
        return specificService.reportsSpecificDesing()
    }

    @GetMapping("/reports/nursing")
    fun reportsNursing(): SpecificReportsDto {
        return specificService.reportsSpecificNursing()
    }

    @GetMapping("/reports/gastronomy")
    fun reportsGastronomy(): SpecificReportsDto {
        return specificService.reportsSpecificGastronomy()
    }

    @GetMapping("/reports/tourism")
    fun reportsTourism(): SpecificReportsDto {
        return specificService.reportsSpecificTourism()
    }

    @GetMapping("/reports/marketing")
    fun reportsMarketing(): SpecificReportsDto {
        return specificService.reportsSpecificMarketing()
    }

    @PostMapping
    fun save(@RequestBody specific:Specific):Specific{
        return specificService.save(specific)
    }
    @PutMapping
    fun update(@RequestBody specific:Specific): Specific {
        return specificService.save(specific)
    }


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean{
        return specificService.delete(id)
    }
}