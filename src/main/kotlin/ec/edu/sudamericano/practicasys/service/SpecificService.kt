package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.model.*
import ec.edu.sudamericano.practicasys.model.dto.SpecificReportsDto
import ec.edu.sudamericano.practicasys.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SpecificService {
    @Autowired
    lateinit var specificRepository: SpecificRepository
    @Autowired
    lateinit var specificViewRepository: SpecificViewRepository
    @Autowired
    lateinit var specificViewCurrentRepository: SpecificViewCurrentRepository
    @Autowired
    lateinit var specificViewExpiredRepository: SpecificViewExpiredRepository


    fun list(): List<Specific> {

        return specificRepository.findAll()
    }

    fun listSpecific (): List<SpecificView>{
        return specificViewRepository.findAll()
    }

    fun listByCareer (career:String?): List<SpecificViewCurrent>{
        return specificViewCurrentRepository.findByCareer(career)
    }

    fun listSpecificCurrent (): List<SpecificViewCurrent>{
        return specificViewCurrentRepository.findAll()
    }

    fun listSpecificExpired (): List<SpecificViewExpired>{
        return specificViewExpiredRepository.findAll()
    }


    fun listById (id:Long?): Specific?{
        return specificRepository.findById(id)
    }

    fun reportsSpecificSoftware(): SpecificReportsDto {
        val response= SpecificReportsDto().apply {
            specificExpiredSoftware= specificRepository.getExpiredSoftware()
            specificCurrentSoftware=specificRepository.getCurrentSoftware()
            specificSoonSoftware=specificRepository.getSoonSoftware()
        }
        return response
    }

    fun reportsSpecificDesing(): SpecificReportsDto {
        val response= SpecificReportsDto().apply {
            specificExpiredDesing= specificRepository.getExpiredDesing()
            specificCurrentDesing=specificRepository.getCurrentDesing()
            specificSoonDesing=specificRepository.getSoonDesing()
        }
        return response
    }

    fun reportsSpecificNursing(): SpecificReportsDto {
        val response= SpecificReportsDto().apply {
            specificExpiredNursing= specificRepository.getExpiredNursing()
            specificCurrentNursing=specificRepository.getCurrentNursing()
            specificSoonNursing=specificRepository.getSoonNursing()
        }
        return response
    }

    fun reportsSpecificGastronomy(): SpecificReportsDto {
        val response= SpecificReportsDto().apply {
            specificExpiredGastro= specificRepository.getExpiredGastro()
            specificCurrentGastro=specificRepository.getCurrentGastro()
            specificSoonGastro=specificRepository.getSoonGastro()
        }
        return response
    }

    fun reportsSpecificTourism(): SpecificReportsDto {
        val response= SpecificReportsDto().apply {
            specificExpiredTourism= specificRepository.getExpiredTourism()
            specificCurrentTourism=specificRepository.getCurrentTourism()
            specificSoonTourism=specificRepository.getSoonTourism()
        }
        return response
    }

    fun reportsSpecificMarketing(): SpecificReportsDto {
        val response= SpecificReportsDto().apply {
            specificExpiredMarketing= specificRepository.getExpiredMarketing()
            specificCurrentMarketing=specificRepository.getCurrentMarketing()
            specificSoonMarketing=specificRepository.getSoonMarketing()
        }
        return response
    }

    fun save(specific:Specific):Specific{
        specific.apply {
            sagStatus=true
        }
        return specificRepository.save(specific)
    }
    fun update(specific:Specific): Specific {
        val response =specificRepository.findById(specific.id)
        if (response==null){
            throw Exception()
        }else{
            return specificRepository.save(specific)
        }
    }

    fun delete(id:Long):Boolean{
        specificRepository.deleteById(id)
        return true
    }
}


