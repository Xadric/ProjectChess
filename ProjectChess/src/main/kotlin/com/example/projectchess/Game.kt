package com.example.projectchess

import javafx.event.EventHandler
import javafx.scene.effect.DropShadow
import javafx.scene.effect.Glow
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color

class Game(chessBoard: GridPane, theme: String) {
    private var game = false
    companion object {
        var currPiece: Piece? = null
        var currPlayer:String = "white"
        lateinit var cb:ChessBoard
    }
    init {
        cb = ChessBoard(chessBoard, theme)
        this.game=true
        addEventHandlers(cb.chessBoard!!)
    }

    private fun addEventHandlers(chessBoard: GridPane) {
        chessBoard.onMouseClicked = EventHandler { event:MouseEvent ->
            val target = event.target
//            println(target.toString())
            if (target.toString()=="Square"){
                val square = target as Square
                if (square.isOccupated){
                    val piece = square.children[0] as Piece
                    if (currPiece==null) {
                        if (piece.color== currPlayer) {
                            currPiece = piece
                            selectPiece(game)
//                            currPiece!!.showAllPosibleMoves(game,cb)
                            showAllPosibleMoves(game)
                        }
                    }else {
                        if (currPiece!!.canPieceMove(square.col,square.row))
                        if (currPiece!!.color!=piece.color)
                        killPiece(square)
                    }
                }else{
                    if (currPiece != null)
                        if (currPiece!!.canPieceMove(square.col,square.row))
                        dropPiece(square)
                }
            }
        }
    }

    private fun showAllPosibleMoves(game: Boolean) {
        if(game){
            var pp = currPiece!!.parent.parent as GridPane
            for (i in 0.. pp.children.size-1){
                var child = pp.children[i] as Square
                if (currPiece!!.canPieceMove(child.col,child.row)){
                    var effect = Glow()
                    child.effect=effect
                }
            }
//            println(pp[0].row)
//            println(pp[0].col)
        }
    }


    private fun dropPiece(square: Square) {
        val parent = currPiece!!.parent as Square
        parent.isOccupated=false
        parent.children.removeAll()
        square.children.add(currPiece)
        square.isOccupated=true
        deselectPiece(true)
//        println(square.children[0])
        var currentPiece=square.children[0] as Piece
        currentPiece.row=square.col
        currentPiece.col=square.row
        val pp=parent.parent as GridPane

    }

    private fun deselectPiece(changePlayer: Boolean) {
        currPiece!!.effect=null
        for (i in 0..(currPiece!!.parent.parent as GridPane).children.size-1) {
            var pp = (currPiece!!.parent.parent as GridPane).children[i] as Square
            pp.effect=null
            if (pp.isOccupated) {
                val ppc = pp.children[0] as Piece
                ppc.effect=null
            }
        }
        currPiece=null
        if (changePlayer){
            currPlayer=if(currPlayer=="white")"black" else "white"
        }
    }

    private fun killPiece(square: Square) {
        val killedPiece = square.children[0] as Piece
        square.children.removeFirst()
        dropPiece(square)
        println(killedPiece)
        if (killedPiece.type=="King")this.game=false
    }

    private fun selectPiece(game: Boolean) {
        if (!game) {
            currPiece=null
            return
        }
            val shadow = DropShadow()
            shadow.color = Color.GREEN
            shadow.width = 50.0
            shadow.height = 50.0
            shadow.spread = 0.7
            currPiece!!.effect = shadow

    }
}
