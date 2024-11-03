module com.example.biydaalt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.biydaalt to javafx.fxml;
    exports com.example.biydaalt;
}