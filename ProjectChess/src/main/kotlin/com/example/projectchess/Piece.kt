package com.example.projectchess

import javafx.scene.effect.Shadow
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.paint.Color

open class Piece(var color:String, var row:Int, var col:Int,var type:String):ImageView() {
    var kolMoves = 0

    //    var type:String?=null
    fun setPiece(image:Image){
        this.image=image
    }

    fun setImage(){
        var namePiece ="pieces/"+ this.color+""+this.type+".png"
//        var namePiece ="pieces/whiteKing.png"
//        println(namePiece)
        this.setPiece(Image(javaClass.getResourceAsStream(namePiece)))
    }

    open fun canPieceMove(rowFin: Int, colFin: Int): Boolean{
        return (rowFin in 0..7)&&(colFin in 0..7)
    }


//    fun getType():String{
//        return type
//    }
 fun setPossibleKillShadow(): Shadow {
    // create target color

    val targetColor = Color.RED
    var effect = Shadow()
    effect.color=targetColor
//    effect.width = 50.0
//    effect.height = 50.0

    return effect
}
}