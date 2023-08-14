package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="career")
class Carrera {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var name:String? = null
    var coordinator:String? = null
}