module com.example.almacendematerial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.almacendematerial to javafx.fxml;
    exports com.example.almacendematerial;
}