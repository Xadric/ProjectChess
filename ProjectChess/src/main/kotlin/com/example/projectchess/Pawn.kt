package com.example.projectchess

import javafx.scene.layout.GridPane


open class Pawn(color: String, row: Int, col: Int) : Piece(color, row, col, "Pawn") {
    override fun canPieceMove(rowFin: Int, colFin: Int): Boolean {
        if (super.canPieceMove(rowFin, colFin)) {
//        if (((isWhite && rowFin - row > 0)||(!isWhite &&  rowFin - row < 0)))
//        if(abs( colFin-col) <= 1){
//            if ((abs(rowFin - row) == 2 && (row == 2 || row == 7) && ( colFin-col)==0)) return true
//            if (abs(rowFin - row) == 1 ) return true
//        }
            val dir = if (color == "white") -1 else 1
//            println("$row $col ")
//            println(" $rowFin $colFin")
            if (col == colFin && rowFin == row + dir) return true
            if (col == colFin && rowFin == row + 2 * dir && (row == 1 || row == 6)) return true

            val pp = this.parent.parent as GridPane
            var child = pp.children[0] as Square
            for (i in 0..<pp.children.size){
                val cc = pp.children[i] as Square
                if (cc.col == rowFin && cc.row == colFin) child=cc
            }
            if (child.isOccupated)
            if ((col == colFin - 1 || col == colFin + 1) && rowFin == row + dir) {
                val ccp = child.children[0] as Piece
                if (ccp.color!=this.color) {
                    ccp.effect=setPossibleKillShadow()

                    return true
                }
            }


        }
        return false
    }
}