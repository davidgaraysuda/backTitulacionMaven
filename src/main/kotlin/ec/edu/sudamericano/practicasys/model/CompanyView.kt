package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="company_view")
class CompanyView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name:String? = null
    var phone:String? = null
    var contact:String? = null
    var coordinates:String? = null
    var status: Boolean? = null
    @Column(name = "tutor_id")
    var tutorId: Long? = null
    var tutor:String?=null
}