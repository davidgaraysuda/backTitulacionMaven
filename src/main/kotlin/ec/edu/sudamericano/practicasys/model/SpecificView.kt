package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="specific_view")
class SpecificView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="link_sdoc")
    var linkSdoc:String?=null
    @Column(name = "sag_status")
    var sagStatus: Boolean? = null
    @Column(name="agreement_id")
    var agreementId:Long?=null
    var company:String?=null
    @Column(name="career_id")
    var careerId:Long?=null
    var career:String?=null
}