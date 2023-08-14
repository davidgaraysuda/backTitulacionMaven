package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="teacher")
class Teacher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name:String? = null
    var phone:String? = null
    @Column(name="te_status")
    var teStatus:Boolean? = null
    @Column(name="career_id")
    var careerId:Long? = null

}