package com.example.projectchess

import javafx.scene.layout.GridPane
import kotlin.math.*

open class King(color: String, row: Int, col: Int) : Piece(color, row, col, "King") {

       override fun canPieceMove(rowFin: Int, colFin: Int): Boolean {
        if ( super.canPieceMove( rowFin, colFin) && (abs(rowFin - row) <= 1 && abs(colFin - col) <= 1)){
            val pp = this.parent.parent as GridPane

            for (j in 0..<pp.children.size){
                val cc = pp.children[j] as Square

                if (cc.col == rowFin && cc.row == colFin && cc.isOccupated){
                    val ccp = cc.children[0] as Piece
                    if ( ccp.color!=this.color){
                        ccp.effect=setPossibleKillShadow()
                        return true
                    }
                    return false
                }
            }
            return true
        }
           var kolMovesRook = -1
           val rookPosCol=if (colFin ==2)0 else 7
           val pp = this.parent.parent as GridPane
           for (j in 0..<pp.children.size){
               val cc=pp.children[j] as Square
               if (cc.col==rowFin && cc.row ==rookPosCol && cc.isOccupated){
                   val ccp= cc.children[0] as Piece

                   if (ccp.type=="Rook")
                   kolMovesRook=ccp.kolMoves
               }

           }
//           println(kolMovesRook)
            if(this.kolMoves==0 && kolMovesRook==0){
//                println(""+rowFin+" "+colFin)
                if(this.color=="white"){
                    if(rowFin==7 &&  colFin==2){


                        for (j in 0..<pp.children.size){
                            val cc=pp.children[j] as Square
//                            if (cc.col==7 && cc.row in 1..3 && cc.isOccupated)
//                                println(cc.children[0] as Piece)
                            if (cc.col==7 && cc.row in 1..3 && cc.isOccupated)return false

                        }
                        return true
                    }else if (rowFin==7 && colFin==6 ){
                        val pp = this.parent.parent as GridPane

                        for (j in 0..<pp.children.size){
                            val cc=pp.children[j] as Square
                            if (cc.col==7 && cc.row in 5..6 && cc.isOccupated)return false

                        }
                        return true
                    }
                }else{
                    if(rowFin==0 &&  colFin==2){
                        val pp = this.parent.parent as GridPane

                        for (j in 0..<pp.children.size){
                            val cc=pp.children[j] as Square
                            if (cc.col==0 && cc.row in 1..3 && cc.isOccupated)return false

                        }
                        return true
                    }else if (rowFin==0 && colFin==6 ){
                        val pp = this.parent.parent as GridPane

                        for (j in 0..<pp.children.size){
                            val cc=pp.children[j] as Square
                            if (cc.col==0 && cc.row in 5..6 && cc.isOccupated)return false

                        }
                        return true
                    }
                }
            }
           return false
    }

   /* override fun showAllPosibleMoves(isOn: Boolean, cb: ChessBoard): ArrayList<String>? {
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
    }*/
}