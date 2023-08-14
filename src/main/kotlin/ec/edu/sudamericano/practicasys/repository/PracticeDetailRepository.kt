package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.PracticeDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDate

interface PracticeDetailRepository: JpaRepository<PracticeDetail, Long?> {
    fun findById(id: Long?): PracticeDetail?

    @Query(nativeQuery = true)
    fun listDetailByPractice (@Param("practiceId") practiceId:Long): List<PracticeDetail>

    fun findByPracticeId (@Param("practiceId") practiceId:Long): List<PracticeDetail>

    @Query(nativeQuery = true)
    fun listWeekRange(@Param("practiceId") practiceId:Long, @Param("dateStart")dateStart: LocalDate, @Param("dateEnd")dateEnd: LocalDate): List<PracticeDetail>


}