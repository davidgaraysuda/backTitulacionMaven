package ec.edu.sudamericano.practicasys.model

import java.util.*
import jakarta.persistence.*

@Entity
@Table(name = "practice_detail_view")
class PracticeDetailView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "actual_date")
    var actualDate: Date? = null

    @Column(name = "start_time")
    var startTime: String? = null

    @Column(name = "end_time")
    var endTime: String? = null

    @Column(name = "total_hours")
    var totalHours: Long? = null

    @Column(name = "practice_id")
    var practiceId: Long? = null
    var estudiante:String?=null
    var company:String?=null
}