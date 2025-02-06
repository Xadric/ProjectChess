package com.example.projectchess

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.layout.GridPane

class HelloController {
    @FXML
    lateinit var chessBoard: GridPane

    fun initialize(){
        val game = Game(chessBoard,"CoralLesson")
    }
}