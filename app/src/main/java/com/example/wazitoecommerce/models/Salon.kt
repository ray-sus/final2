package com.example.wazitoecommerce.models

class Salon {
    var name:String = ""
    var phonenumber:String = ""
    var description:String = ""
    var imageUrl:String = ""


    constructor(name: String, phonenumber: String, description: String, imageUrl: String ) {
        this.name = name
        this.phonenumber = phonenumber
        this.description = description
        this.imageUrl = imageUrl

    }

    constructor()
}
