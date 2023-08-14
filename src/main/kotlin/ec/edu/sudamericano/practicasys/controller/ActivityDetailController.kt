package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.model.ActivityDetail
import ec.edu.sudamericano.practicasys.model.ActivityDetailView
import ec.edu.sudamericano.practicasys.service.ActivityDetailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/activitydtl")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class ActivityDetailController {
    @Autowired
    lateinit var activityDetailService: ActivityDetailService

    @GetMapping
    fun list(): List<ActivityDetail>{
        return activityDetailService.list()
    }
    @GetMapping("/{detailId}/detail")
    fun listActivities(@PathVariable("detailId") detailId:Long): List<ActivityDetail>{
        return activityDetailService.listDetailId(detailId)
    }
    /*--------------lista*/
    @GetMapping("/{detailId}/full")
    fun listFull(@PathVariable("detailId") detailId:Long): List<ActivityDetailView>{
        return activityDetailService.listActivitiesDetailFull(detailId)
    }


    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): ActivityDetail?{
        return activityDetailService.listById(id)
    }
    @PostMapping
    fun save(@RequestBody ActivityDetail: ActivityDetail):ActivityDetail{
        return activityDetailService.save(ActivityDetail)
    }

    @PutMapping
    fun update(@RequestBody ActivityDetail: ActivityDetail):ActivityDetail{
        return activityDetailService.update(ActivityDetail)
    }


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean{
        return activityDetailService.delete(id)
    }
}