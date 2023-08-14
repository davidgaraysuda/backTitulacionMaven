package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.Agreement
import ec.edu.sudamericano.practicasys.model.AgreementView
import ec.edu.sudamericano.practicasys.model.AgreementViewCurrent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AgreementRepository: JpaRepository<Agreement, Long?> {
    fun findById(id: Long?): Agreement?
    @Query(value="select count(a) from agreement a where extract(day from(end_date-now()))<90 and extract(day from(end_date-now()))>1", nativeQuery = true)
    fun getTotalSoon():Long
    @Query(value="select count(a) from agreement a where extract(day from(a.end_date-now()))>0", nativeQuery = true)
    fun getTotalCurrent():Long

    @Query(value="select count(*) from agreement a where extract(day from(end_date-now()))<0", nativeQuery = true)
    fun getTotalExpired():Long
}