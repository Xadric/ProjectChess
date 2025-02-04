package com.example.projectchess

import javafx.scene.layout.GridPane
import kotlin.math.abs


open class Rook(color: String, row: Int, col: Int) : Piece(color, row, col, "Rook"){
    override fun canPieceMove(rowFin: Int, colFin: Int): Boolean {
        if( super.canPieceMove(rowFin,colFin) &&
            ((rowFin==row && colFin!=col) || (colFin==col && rowFin!=row))){

            val pp = this.parent.parent as GridPane
            if(rowFin==row){
                println("$rowFin $colFin")
                val dirCol = (col-colFin)/ abs(col-colFin)
                println((colFin-col)*dirCol)
                var i = 1
                while (i <= (colFin-col)*dirCol){
                    println(col+(i*dirCol))
                    for (j in 0..<pp.children.size){
                        val cc = pp.children[j] as Square

                        if ( cc.row == col+(i*dirCol) && cc.isOccupated){
                            val ccp = cc.children[0] as Piece
                            if ( col+(i*dirCol)==colFin && ccp.color!=this.color)return true
                            return false
                        }
                    }
                    i++
                }
            }else{
                val dirRow = (row-rowFin)/ abs(row-rowFin)
                var i = 1
                while (i <= (colFin-col)*dirRow){
                    for (j in 0..<pp.children.size){
                        val cc = pp.children[j] as Square

                        if ( cc.col == rowFin && cc.isOccupated){
                            val ccp = cc.children[0] as Piece
                            if ( row+(i*dirRow)==rowFin && ccp.color!=this.color)return true
                            return false
                        }
                    }
                    i++
                }
            }
        }
        return false
    }
}