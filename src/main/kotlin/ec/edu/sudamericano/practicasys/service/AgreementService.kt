package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.model.Agreement
import ec.edu.sudamericano.practicasys.model.AgreementView
import ec.edu.sudamericano.practicasys.model.AgreementViewCurrent
import ec.edu.sudamericano.practicasys.model.AgreementViewExpired
import ec.edu.sudamericano.practicasys.model.dto.AgreementReportsDto
import ec.edu.sudamericano.practicasys.repository.AgreementRepository
import ec.edu.sudamericano.practicasys.repository.AgreementViewCurrentRepository
import ec.edu.sudamericano.practicasys.repository.AgreementViewExpiredRepository
import ec.edu.sudamericano.practicasys.repository.AgreementViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AgreementService {
    @Autowired
    lateinit var agreementRepository: AgreementRepository
    @Autowired
    lateinit var agreementViewRepository: AgreementViewRepository
    @Autowired
    lateinit var agreementViewCurrentRepository: AgreementViewCurrentRepository
    @Autowired
    lateinit var agreementViewExpiredRepository: AgreementViewExpiredRepository

    fun list(): List<Agreement> {
        return agreementRepository.findAll()
    }
    fun listById (id:Long?): Agreement ?{
        return agreementRepository.findById(id)
    }


    fun listFull(): List<AgreementView> {
        return agreementViewRepository.findAll()
    }

    fun listCurrent(): List<AgreementViewCurrent> {
        return agreementViewCurrentRepository.findAll()
    }

    fun listExpired(): List<AgreementViewExpired> {
        return agreementViewExpiredRepository.findAll()
    }

    fun reportsAgreement():AgreementReportsDto{
        val response= AgreementReportsDto().apply {
            expired= agreementRepository.getTotalExpired()
            soon=agreementRepository.getTotalSoon()
            current=agreementRepository.getTotalCurrent()
        }
        return response
    }

    fun save(agreement : Agreement ):Agreement {
        agreement.apply {
            agStatus=true
        }
        return agreementRepository.save(agreement )
    }

    fun update(agreement : Agreement ):Agreement {
        val response =agreementRepository.findById(agreement .id)
        if (response==null){
            throw Exception()
        }else{
            return agreementRepository.save(agreement )
        }
    }

    fun delete(id:Long):Boolean{
        agreementRepository.deleteById(id)
        return true
    }
}


