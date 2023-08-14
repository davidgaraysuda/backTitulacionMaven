package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="activity")
class Activity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Column(updatable = false)
    var id: Long? = null
    var description:String? = null
    @Column(name="career_id")
    var careerId: Long? = null
}