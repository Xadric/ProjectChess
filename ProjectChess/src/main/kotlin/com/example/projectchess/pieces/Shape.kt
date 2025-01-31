package com.example.projectchess.pieces

open class Shape {
    var isWhite=false
    var row=0
    var col=0



    fun createShape(col: Int, row: Int ,isWhite:Boolean ){
        this.row =row
        this.col =col
        this.isWhite=isWhite


    }
    fun canShapeMove( colFin: Int, rowFin: Int): Boolean{
        return (rowFin in 1..8)&&(colFin in 1..8)
    }

}