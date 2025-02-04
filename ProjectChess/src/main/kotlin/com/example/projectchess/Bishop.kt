package com.example.projectchess

import kotlin.math.abs

class Bishop(color: String, row: Int, col: Int) : Piece(color, row, col, "Bishop") {
    override fun canPieceMove(rowFin: Int,  colFin: Int): Boolean {
        return super.canPieceMove(rowFin,colFin) &&
                (abs(rowFin-row) == abs(colFin-col))

    }
}