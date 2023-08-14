package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.Specific
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SpecificRepository: JpaRepository<Specific, Long?> {
    fun findById(id: Long?): Specific?
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=1 and extract(day from(ag.end_date-now()))<90 and extract(day from(end_date-now()))>1", nativeQuery = true)
    fun getSoonSoftware():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=1 and extract(day from(ag.end_date-now()))>0", nativeQuery = true)
    fun getCurrentSoftware():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=1 and extract(day from(ag.end_date-now()))<0", nativeQuery = true)
    fun getExpiredSoftware():Long

    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=2 and extract(day from(ag.end_date-now()))<90 and extract(day from(end_date-now()))>1", nativeQuery = true)
    fun getSoonDesing():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=2 and extract(day from(ag.end_date-now()))>0", nativeQuery = true)
    fun getCurrentDesing():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=2 and extract(day from(ag.end_date-now()))<0", nativeQuery = true)
    fun getExpiredDesing():Long

    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=3 and extract(day from(ag.end_date-now()))<90 and extract(day from(end_date-now()))>1", nativeQuery = true)
    fun getSoonNursing():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=3 and extract(day from(ag.end_date-now()))>0", nativeQuery = true)
    fun getCurrentNursing():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=3 and extract(day from(ag.end_date-now()))<0", nativeQuery = true)
    fun getExpiredNursing():Long

    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=4 and extract(day from(ag.end_date-now()))<90 and extract(day from(end_date-now()))>1", nativeQuery = true)
    fun getSoonGastro():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=4 and extract(day from(ag.end_date-now()))>0", nativeQuery = true)
    fun getCurrentGastro():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=4 and extract(day from(ag.end_date-now()))<0", nativeQuery = true)
    fun getExpiredGastro():Long

    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=5 and extract(day from(ag.end_date-now()))<90 and extract(day from(end_date-now()))>1", nativeQuery = true)
    fun getSoonTourism():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=5 and extract(day from(ag.end_date-now()))>0", nativeQuery = true)
    fun getCurrentTourism():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=5 and extract(day from(ag.end_date-now()))<0", nativeQuery = true)
    fun getExpiredTourism():Long

    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=6 and extract(day from(ag.end_date-now()))<90 and extract(day from(end_date-now()))>1", nativeQuery = true)
    fun getSoonMarketing():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=6 and extract(day from(ag.end_date-now()))>0", nativeQuery = true)
    fun getCurrentMarketing():Long
    @Query(value="select count(*) as current from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id where career_id=6 and extract(day from(ag.end_date-now()))<0", nativeQuery = true)
    fun getExpiredMarketing():Long

}