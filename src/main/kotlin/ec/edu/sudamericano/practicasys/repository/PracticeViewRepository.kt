package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.PracticeView
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface PracticeViewRepository: JpaRepository<PracticeView, Long?> {
    fun findById(id: Long?): PracticeView?
    @Query(nativeQuery = true)
    fun listPracticeByStudent (@Param("studentId") studentId:Long): List<PracticeView>

    fun findByStudentIdAndTutorId(studentId: Long, tutorId: Long): PracticeView
}