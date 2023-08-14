package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.model.Activity
import ec.edu.sudamericano.practicasys.model.ActivityView
import ec.edu.sudamericano.practicasys.repository.ActivityRepository
import ec.edu.sudamericano.practicasys.repository.ActivityViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ActivityService {
    @Autowired
    lateinit var activityRepository: ActivityRepository
    @Autowired
    lateinit var activityViewRepository: ActivityViewRepository
    fun list(): List<Activity> {
        return activityRepository.findAll()
        //return carreraRepository.findAll()
    }
    fun listById (id:Long?): Activity?{
        return activityRepository.findById(id)
    }
    fun ListCarrera():List<ActivityView>{
        return activityViewRepository.findAll()
    }

    fun save(Activity: Activity):Activity{
        return activityRepository.save(Activity)
    }

    fun update(Activity: Activity):Activity{
        val response =activityRepository.findById(Activity.id)
        if (response==null){
            throw Exception()
        }else{
            return activityRepository.save(Activity)
        }
    }

    fun delete(id:Long):Boolean{
        activityRepository.deleteById(id)
        return true
    }
}


