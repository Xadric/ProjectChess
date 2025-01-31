package com.example.projectchess

import javafx.scene.layout.StackPane

class Square(var row: Int, var col: Int) : StackPane() {
var isOccupated=false
    var name:String?=null

//    fun setName(name:String?){
//        this.name=name
//    }
    override fun toString(): String {
        return "Square"
    }
}

