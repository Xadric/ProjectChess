package com.example.projectchess

import javafx.scene.layout.GridPane
import kotlin.math.abs

open class Queen(color: String, row: Int, col: Int) : Piece(color, row, col,"Queen") {

    override fun canPieceMove(rowFin: Int, colFin: Int): Boolean {
        if( super.canPieceMove(rowFin,colFin) &&(
                ((rowFin==row)|| (colFin==col)) ||
                (abs(rowFin-row) == abs(colFin-col))
                )){
            if((abs(rowFin-row) == abs(colFin-col))&& (colFin!=col && rowFin!=row)){
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
            }else if ((rowFin==row && colFin!=col) || (colFin==col && rowFin!=row)){
                val pp = this.parent.parent as GridPane
//            var child = pp.children[0] as Square
                var dirCol=0
                var dirRow=0

                if (rowFin-row == 0){
                    dirCol=(colFin-col)/abs(colFin-col)
                }else {
                    dirRow = (rowFin - row) / abs(rowFin - row)
                }
//            println("$rowFin $colFin")
//            println((rowFin-row)*dirRow)

                var i = 1
                val maxi = if(dirRow==0)(colFin-col)*dirCol else(rowFin-row)*dirRow
                while (i <= maxi){
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
            }
        }
        return false
    }
}