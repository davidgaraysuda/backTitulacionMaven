package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="tutor")
class Tutor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name:String? = null
    var phone:String? = null
    var alternative:String? = null
    @Column(name="is_main")
    var isMain:Boolean?=null
    @Column(name = "company_id")
    var companyId: Long? = null
    @Column(name="tu_status")
    var tuStatus:Boolean? = null

}