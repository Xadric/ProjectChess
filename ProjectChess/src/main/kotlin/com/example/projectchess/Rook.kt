package com.example.projectchess


open class Rook(color: String, row: Int, col: Int) : Piece(color, row, col, "Rook"){
    override fun canPieceMove(rowFin: Int, colFin: Int): Boolean {
        return super.canPieceMove(rowFin,colFin) &&
                (rowFin==row)|| (colFin==col)
    }
}