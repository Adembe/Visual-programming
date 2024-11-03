module com.example.yvts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.yvts to javafx.fxml;
    exports com.example.yvts;
}