package com.osamadev.computingassignment1.model

class data(){
    lateinit var name : String
    lateinit var number: String
    lateinit var address : String
    constructor(name:String ,number:String ,address:String):this(){
        this.name = name
        this.number = number
        this.address = address
    }

}