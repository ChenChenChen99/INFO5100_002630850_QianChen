module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;


    opens com.example.project to javafx.fxml;
    exports com.example.project;
}