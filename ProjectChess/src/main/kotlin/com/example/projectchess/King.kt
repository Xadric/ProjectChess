package com.example.projectchess

import javafx.scene.layout.GridPane
import kotlin.math.abs
open class King(color: String, row: Int, col: Int) : Piece(color, row, col, "King") {

       override fun canPieceMove(rowFin: Int, colFin: Int): Boolean {
        if ( super.canPieceMove( rowFin, colFin) && (abs(rowFin - row) <= 1 && abs(colFin - col) <= 1)){
            val pp = this.parent.parent as GridPane

            for (j in 0..<pp.children.size){
                val cc = pp.children[j] as Square

                if (cc.col == rowFin && cc.row == colFin && cc.isOccupated){
                    val ccp = cc.children[0] as Piece
                    if ( ccp.color!=this.color){
                        ccp.effect=setPossibleKillShadow()
                        return true
                    }
                    return false
                }
            }
            return true
        }
           return false
    }

   /* override fun showAllPosibleMoves(isOn: Boolean, cb: ChessBoard): ArrayList<String>? {
        val moves = ArrayList<String>()
        this.posibleMoves = ArrayList()
        val row = row
        val col = col
        moves.add("Square "+(row-1)+(col-1))
        moves.add("Square "+(row-1)+(col))
        moves.add("Square "+(row-1)+(col+1))
        moves.add("Square "+(row)+(col-1))
        moves.add("Square "+(row)+(col+1))
        moves.add("Square "+(row+1)+(col-1))
        moves.add("Square "+(row+1)+(col))
        moves.add("Square "+(row+1)+(col+1))
        return super.showAllPosibleMoves(isOn, cb)
    }*/
}