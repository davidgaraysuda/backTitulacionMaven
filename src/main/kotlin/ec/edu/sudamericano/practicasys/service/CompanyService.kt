package ec.edu.sudamericano.practicasys.service

import ec.edu.sudamericano.practicasys.model.Company
import ec.edu.sudamericano.practicasys.model.CompanyView
import ec.edu.sudamericano.practicasys.repository.CompanyRepository
import ec.edu.sudamericano.practicasys.repository.CompanyViewRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CompanyService {
    @Autowired
    lateinit var companyRepository: CompanyRepository

    @Autowired
    lateinit var companyViewRepository: CompanyViewRepository

    fun list(): List<Company> {

        return companyRepository.findAll()
    }
    fun listById (id:Long?):Company?{
        return companyRepository.findById(id)
    }

    fun listCompany ():List<CompanyView> {
        return companyViewRepository.findAll()
    }

    fun save(company:Company):Company{
        company.apply {
            coStatus=true
        }
        return companyRepository.save(company)
    }

    fun update(company: Company): Company {
        val response =companyRepository.findById(company.id)
        if (response==null){
            throw Exception()
        }else{
            return companyRepository.save(company)
        }
    }

    fun delete(id:Long):Boolean{
        companyRepository.deleteById(id)
        return true
    }
}


