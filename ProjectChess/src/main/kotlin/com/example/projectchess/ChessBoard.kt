package com.example.projectchess

import javafx.geometry.Insets
import javafx.scene.layout.*
import javafx.scene.paint.Color

class ChessBoard(var chessBoard: GridPane?, var theme: String) {
    var squares=Array(8){Array(8){Square(0,0)} }
    init {
        drawBoard(chessBoard,theme)
    }

    private fun drawBoard(chessBoard: GridPane?, theme: String) {
        var color1=Color.BLACK
        var color2=Color.WHITE
        when(theme){
            "Coral"->{color1=Color.DARKBLUE; color2=Color.AQUA}
            "CoralLesson"->{color1=Color.web("#b1e4b9");color2=Color.web("#70a2a3")}
            "Dusk"->{color1=Color.web("#cbb7ae");color2=Color.web("#716677")}
            "SandCastle"->{color1=Color.web("#cbb7ae");color2=Color.web("#716677")}
            else->println("Error: no theme named $theme")
        }


        for (i in 0..7)
            for (j in 0..7) {
                val square = Square(i,j)
                square.prefWidth = 100.0
                square.prefHeight = 100.0
                if ((i+j)%2 ==0) square.background = Background(BackgroundFill(color1, CornerRadii.EMPTY, Insets.EMPTY))
                else square.background = Background(BackgroundFill(color2, CornerRadii.EMPTY, Insets.EMPTY))
                square.border = Border(BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii(0.5), BorderWidths.DEFAULT))
                chessBoard?.add(square, i,j)
                squares[i][j]=square
            }
        addPieces()
    }

    private fun addPieces() {
//        val square = squares[0][0]
        for (squareRow in squares)
            for (square in squareRow) {
                var color = ""
                var figure=Piece(color,square.row,square.col,"")
                if (square.col == 0 || square.col == 1) color="black"
                else color="white"

                if(square.col == 1 || square.col==6)figure= Pawn(color,square.col,square.row)
                else  if(square.col == 0 || square.col==7){
                    when(square.row){
                        0  -> figure = Rook(color,square.col,square.row)
                        1  -> figure = Knight(color,square.col,square.row)
                        2  -> figure = Bishop(color,square.col,square.row)
                        4  -> figure = King(color,square.col,square.row)
                        3  -> figure = Queen(color,square.col,square.row)
                        5  -> figure = Bishop(color,square.col,square.row)
                        6  -> figure = Knight(color,square.col,square.row)
                        7  -> figure = Rook(color,square.col,square.row)
                    }
                }else continue
                addPiece(square, figure)

            }

    }

    private fun addPiece(square: Square, piece: Piece) {
        square.children.add(piece)
        piece.setImage()
        square.isOccupated=true

    }
}
