package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.model.*
import ec.edu.sudamericano.practicasys.service.PracticeDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/practicedtl")

@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class PracticeDetailController {
    @Autowired
    lateinit var practiceDetailService: PracticeDetailService


    @GetMapping
    fun listFull(): List<PracticeDetailView>{
        return practiceDetailService.listFull()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): PracticeDetail?{
        return practiceDetailService.listById(id)
    }
    @GetMapping("/{practiceId}/practice")
    fun listpractica(@PathVariable("practiceId") practiceId:Long): List<PracticeDetail>{
        return practiceDetailService.listDetailByPractice(practiceId)
    }

    @PostMapping
    fun save(@RequestBody practiceDetail: PracticeDetail):PracticeDetail{
        return practiceDetailService.save(practiceDetail)
    }
    @PutMapping
    fun update(@RequestBody practiceDetail: PracticeDetail):PracticeDetail {
        return practiceDetailService.save(practiceDetail)
    }


    @DeleteMapping("/delete/{id}")


    fun delete(@PathVariable("id") id:Long):Boolean{
        return practiceDetailService.delete(id)
    }
}