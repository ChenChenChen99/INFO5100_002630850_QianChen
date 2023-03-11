module com.example.exercise9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exercise9 to javafx.fxml;
    exports com.example.exercise9;
}