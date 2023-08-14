package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="company")
class Company {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name:String? = null
    var phone:String? = null
    var contact:String? = null
    var coordinates:String? = null
    @Column(name = "co_status")
    var coStatus: Boolean? = null
}