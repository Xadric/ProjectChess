module com.example.projectchess {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;


    opens com.example.projectchess to javafx.fxml;
    exports com.example.projectchess;
}