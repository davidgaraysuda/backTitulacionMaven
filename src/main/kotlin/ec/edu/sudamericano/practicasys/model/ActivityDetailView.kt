package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="activity_detail_view")
class ActivityDetailView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    @Column(name="activities_id")
    var activitiesId: Long? = null
    @Column(name="detail_id")
    var detailId: Long? = null
    var cheking:Boolean?=null
}
