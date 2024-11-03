module com.example.lab8_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.lab8_1 to javafx.fxml;
    exports com.example.lab8_1;
}