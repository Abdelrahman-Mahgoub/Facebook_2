module com.example.demo11 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires com.google.gson;

    opens com.example.demo11 to javafx.fxml;
    exports com.example.demo11;
    exports Backend;
    opens Backend to javafx.fxml;
    exports BackendUser;
    opens BackendUser to javafx.fxml;
}