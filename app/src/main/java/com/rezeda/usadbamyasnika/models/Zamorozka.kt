package com.rezeda.usadbamyasnika.models

class Zamorozka {
    var img: String? = null
    var price:String? = null
    var title:String? = null
    var weight:String? = null

    constructor()

    constructor(img:String?, title:String?, weight:String?, price:String?){
        this.img = img
        this.title = title
        this.weight = weight
        this.price = price
    }
}