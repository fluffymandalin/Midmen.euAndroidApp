package com.ozlemkilickiran.hw1


class Event {
    private var eventName:String?=null
    private var imgId=0

    constructor(name:String?,imgId: Int){
        this.eventName=name
        this.imgId=imgId
    }

    fun getName():String?{
        return eventName
    }

    fun setName(name: String?) {
        this.eventName = name
    }

    fun getImgId(): Int {
        return imgId
    }

    fun setImgId(imgId: Int) {
        this.imgId = imgId
    }


}


