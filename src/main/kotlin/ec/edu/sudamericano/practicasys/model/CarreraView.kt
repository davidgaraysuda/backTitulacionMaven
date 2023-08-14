package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="carrera_view")
class CarreraView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name:String? = null
    var coordinator:String? = null
    @Column(name="teacher_id")
    var teacherId: Long? = null
    var profesor:String? = null
}