package com.example.totaltrip.ModelClass

import android.net.Uri

class MountainModalClass {
    var palce: String = ""
    var Location: String = ""
    var Price: String = ""
    var Rate: String = ""
    var Description: String = ""
    var key: String = ""
    var ImageUri: String = ""

    constructor(

        palce: String,
        Location: String,
        Price: String,
        Rate: String,
        Description: String,
        key: String,
        ImageUri: Uri
    )
    {
        this.ImageUri = ImageUri.toString()
        this.palce = palce
        this.Location = Location
        this.Price = Price
        this.Rate = Rate
        this.Description = Description
        this.key = key
    }
    constructor() {

    }
}