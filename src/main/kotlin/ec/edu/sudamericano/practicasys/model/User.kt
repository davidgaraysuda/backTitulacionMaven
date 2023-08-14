package ec.edu.sudamericano.practicasys.model

import jakarta.persistence.*

@Entity
@Table(name="users")
class User {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id: Long? = null
    var firstname: String? = null
    var lastname: String? = null
    var email: String? = null
    var password: String? = null
    var role: String? = null
}