package com.example.projectchess

import kotlin.math.abs

class Bishop(color: String, row: Int, col: Int) : Piece(color, row, col, "Bishop") {
    fun canBishopMove( colFin: Int, rowFin: Int): Boolean {
        return canPieceMove(colFin,rowFin) &&
                (abs(rowFin-row) == abs(colFin-col))

    }
}