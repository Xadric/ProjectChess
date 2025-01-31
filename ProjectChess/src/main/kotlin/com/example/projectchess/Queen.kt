package com.example.projectchess

import kotlin.math.abs

open class Queen(color: String, row: Int, col: Int) : Piece(color, row, col,"Queen") {

    fun canQueenMove(rowFin: Int, colFin: Int): Boolean {
        return canPieceMove(colFin,rowFin) &&(
                ((rowFin==row)|| (colFin==col)) ||
                (abs(rowFin-row) == abs(colFin-col))
                )
    }
}