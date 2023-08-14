package ec.edu.sudamericano.practicasys.repository

import ec.edu.sudamericano.practicasys.model.Practice
import org.springframework.data.jpa.repository.JpaRepository

interface PracticeRepository : JpaRepository<Practice, Long?> {
    fun findById(id: Long?): Practice?

    fun findByStudentIdAndTutorId(studentId: Long, tutorId: Long): Practice

}