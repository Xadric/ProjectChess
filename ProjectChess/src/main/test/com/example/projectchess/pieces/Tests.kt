package com.example.projectchess.pieces

import com.example.projectchess.Bishop
import com.example.projectchess.Knight
import com.example.projectchess.Pawn
import com.example.projectchess.Rook
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Tests {

    @Test
    fun canPawnMoveTest() {
        var pawn1 = Pawn()
        pawn1.createShape(7, 2, true)
        assertTrue(pawn1.canPawnMove(7, 4))

        pawn1.createShape(4, 5, true)
        assertTrue(pawn1.canPawnMove(3, 6))

        pawn1.createShape(7, 7, true)
        assertTrue(pawn1.canPawnMove(7, 8))

        pawn1.createShape(7, 7, true)
        assertTrue(pawn1.canPawnMove(7, 8))

        pawn1.createShape(6, 8, true)
        assertFalse(pawn1.canPawnMove(5, 8))

        pawn1.createShape(2, 7, false)
        assertTrue(pawn1.canPawnMove(2, 6))

        pawn1.createShape(6, 7, false)
        assertTrue(pawn1.canPawnMove(7, 6))
    }

    @Test
    fun canRookMoveTest() {
        var rook1 = Rook()
        rook1.createShape(1, 1, true)
        assertFalse(rook1.canRookMove(8, 8))

    }
    @Test
    fun canBishopMoveTest(){
        var bishop = Bishop()
        bishop.createShape(1, 1, true)
        assertTrue(bishop.canBishopMove(8, 8))
    }

    @Test
    fun canKnightMoveTest(){
        var knight = Knight()
        knight.createShape(5, 5, true)
        assertTrue(knight.canKnightMove(7,6))
    }
}