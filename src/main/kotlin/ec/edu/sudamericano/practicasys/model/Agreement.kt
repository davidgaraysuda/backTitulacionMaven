package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="agreement")
class Agreement {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "start_date")
    var startDate: Date? = null

    @Column(name = "end_date")
    var endDate: Date? = null
    @Column(name = "ag_status")
    var agStatus: Boolean? = null
    @Column(name = "link_doc")
    var linkDoc: String? = null

    @Column(name = "company_id")
    var companyId: Long? = null

}