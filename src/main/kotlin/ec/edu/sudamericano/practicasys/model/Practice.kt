package ec.edu.sudamericano.practicasys.model

import java.util.*
import jakarta.persistence.*

@Entity
@Table(name="practice")
class Practice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name = "start_date")
    var startDate:Date? = null
    @Column(name = "end_date")
    var endDate:Date? = null
    @Column(name = "pra_status")
    var praStatus: Boolean? = null
    var hours:Long?=null
    @Column(name = "student_id")
    var studentId:Long? = null
    @Column(name = "tutor_id")
    var tutorId:Long? = null
    @Column(name = "teacher_id")
    var teacherId:Long? = null


}