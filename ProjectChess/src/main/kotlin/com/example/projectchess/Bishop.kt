package com.example.projectchess

import javafx.scene.layout.GridPane
import kotlin.math.abs

class Bishop(color: String, row: Int, col: Int) : Piece(color, row, col, "Bishop") {
    override fun canPieceMove(rowFin: Int,  colFin: Int): Boolean {
        if(super.canPieceMove(rowFin,colFin) &&
            (abs(rowFin-row) == abs(colFin-col))&&
            (colFin!=col && rowFin!=row)) {
            val pp = this.parent.parent as GridPane
            var child = pp.children[0] as Square
            val dirRow=(rowFin-row)/abs(rowFin-row)
            val dirCol=(colFin-col)/abs(colFin-col)
//            println("$rowFin $colFin")
//            println((rowFin-row)*dirRow)

            var i = 1
            while (i <= (rowFin-row)*dirRow){
//                if (row+(i*dirRow)==rowFin)return true
//                println(""+(row+(i*dirRow)) +" "+(col+(i*dirCol))+"---")
                for (j in 0..<pp.children.size){
                    val cc = pp.children[j] as Square

                    if (cc.col == row+(i*dirRow) && cc.row == col+(i*dirCol) && cc.isOccupated){
                        val ccp = cc.children[0] as Piece
                        if (row+(i*dirRow)==rowFin && col+(i*dirCol)==colFin && ccp.color!=this.color){
                            ccp.effect=setPossibleKillShadow()
                            return true
                        }
                        return false
                    }
                }
                i++
            }
            return true
        }else return false
    }
}