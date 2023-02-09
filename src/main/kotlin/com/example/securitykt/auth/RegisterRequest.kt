package com.example.securitykt.auth

import com.example.securitykt.user.Role

class RegisterRequest {
    var firstname: String? = null
    var lastname: String? = null
    var email: String? = null
    var password: String? = null
    var role: Role? = null
}