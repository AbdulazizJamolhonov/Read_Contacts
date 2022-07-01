package developer.abdulaziz.myreadcontact

import android.graphics.Bitmap

class Contact {
    var name: String = ""
    var phone: String = ""
    var image: Bitmap? = null

    constructor(name: String, phone: String, image: Bitmap?) {
        this.name = name
        this.phone = phone
        this.image = image
    }

    constructor()
    constructor(name: String, phone: String) {
        this.name = name
        this.phone = phone
    }
}