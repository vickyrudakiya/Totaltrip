package com.example.totaltrip.ModelClass

import android.net.Uri

class StudentModelClass {


    var palce: String = ""
    var email: String = ""
    var phonenumber: String = ""
    var Discription: String = ""
    var city: String = ""
    var price: String = ""
    var Rating: String = ""
    var key: String = ""
    var Day:String=""
    var Favourite:String=""
    var ImageUri: String = ""


    constructor(
        palce: String,
        email: String,
        phonenumber: String,
        discription: String,
        city: String,
        price: String,
        rating: String,
        key: String,
        Day:String,
        Favourite:String,
        ImageUri: Uri,

        ) {
        this.palce = palce
        this.email = email
        this.phonenumber = phonenumber
        this.Discription = discription
        this.city = city
        this.price = price
        this.Rating = rating
        this.key = key
        this.Day= Day
        this.Favourite=Favourite
        this.ImageUri = ImageUri.toString()


    }

    constructor() {

    }

}