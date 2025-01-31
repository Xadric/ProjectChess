package com.example.projectchess


class Knight(color: String, row: Int, col: Int) : Piece(color, row, col, "Knight"){
    override fun canPieceMove(rowFin: Int, colFin: Int): Boolean{
        return super.canPieceMove(rowFin,colFin) &&
                (sqr(colFin-col) + sqr(rowFin-row) == 5)

    }

    private fun sqr(i: Int): Int {
        return i*i
    }
}