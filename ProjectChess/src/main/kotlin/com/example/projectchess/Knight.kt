package com.example.projectchess

import javafx.scene.layout.GridPane


class Knight(color: String, row: Int, col: Int) : Piece(color, row, col, "Knight"){
    override fun canPieceMove(rowFin: Int, colFin: Int): Boolean{
        if( super.canPieceMove(rowFin,colFin) &&
                (sqr(colFin-col) + sqr(rowFin-row) == 5)){
            val pp = this.parent.parent as GridPane
            for (i in 0..<pp.children.size){
                val cc = pp.children[i] as Square
                if (cc.col == rowFin && cc.row == colFin) {
                    if (!cc.isOccupated)return true
                    else{
                        val ccp = cc.children[0] as Piece
                        if (ccp.color==this.color){
                            ccp.effect=setPossibleKillShadow()
                            return false
                        }
                        else return true
                    }
                }
            }

        }
        return false
    }

    private fun sqr(i: Int): Int {
        return i*i
    }
}