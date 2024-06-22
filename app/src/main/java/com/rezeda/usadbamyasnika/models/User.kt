package com.rezeda.usadbamyasnika.models

class User {

    var user_name: String? = null
    var user_pass: String? = null

    constructor()

    constructor(user_name: String, user_pass: String){
        this.user_name = user_name
        this.user_pass = user_pass
    }
}