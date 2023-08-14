package ec.edu.sudamericano.practicasys.model.dto

import ec.edu.sudamericano.practicasys.model.Role

class RegisterRequest {
    var firstname: String? = null
    var lastname: String? = null
    var email: String? = null
    var password: String? = null
    var role: Role? = null
}