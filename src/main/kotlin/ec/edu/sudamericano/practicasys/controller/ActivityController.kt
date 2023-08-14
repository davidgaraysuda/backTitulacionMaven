package ec.edu.sudamericano.practicasys.controller

import ec.edu.sudamericano.practicasys.model.Activity
import ec.edu.sudamericano.practicasys.model.ActivityView
import ec.edu.sudamericano.practicasys.service.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/activity")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT,RequestMethod.DELETE])

class ActivityController {
    @Autowired
    lateinit var activityService: ActivityService

    @GetMapping
    fun list(): List<Activity>{
        return activityService.list()
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Activity?{
        return activityService.listById(id)
    }
    @GetMapping("/with/carrera")
    fun listAc():List<ActivityView>{
        return activityService.ListCarrera()
    }
    @PostMapping
    fun save(@RequestBody Activity: Activity):Activity{
        return activityService.save(Activity)
    }

    @PutMapping
    fun update(@RequestBody Activity: Activity):Activity{
        return activityService.update(Activity)
    }


    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id:Long):Boolean{
        return activityService.delete(id)
    }
}