module com.example.bookbrowser {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.bookbrowser to javafx.fxml;
    exports com.example.bookbrowser;
}