package model

class Student {
    var id: String
    var name: String
    var password: String
    var email: String
    var age: Int
    var premium: Boolean
    var photo: String

    constructor(id: String, name: String, password: String, email: String, age: Int, premium: Boolean, photo: String) {
        this.id = id
        this.name = name
        this.password = password
        this.email = email
        this.age = age
        this.premium = premium
        this.photo = photo
    }
}