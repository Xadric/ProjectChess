package com.example.projectchess

import kotlin.math.abs
open class King(color: String, row: Int, col: Int) : Piece(color, row, col, "King") {

       override fun canPieceMove(rowFin: Int, colFin: Int): Boolean {
        return super.canPieceMove( rowFin, colFin) && (abs(rowFin - row) <= 1 && abs(colFin - col) <= 1)
    }

    override fun showAllPosibleMoves(isOn: Boolean, cb: ChessBoard): ArrayList<String>? {
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
    }
}