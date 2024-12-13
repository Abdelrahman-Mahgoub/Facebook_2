package com.example.demo11;

import BackendUser.Hashing;
import BackendUser.User;
import BackendUser.UserDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class SignupController {
    @FXML
    private TextField emailField;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private DatePicker dobPicker;

    @FXML
    private void handleSignUp() throws IOException {
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = passwordField.getText();
        LocalDate dob = dobPicker.getValue();

        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || dob == null) {
            System.out.println("All fields are required.");
            return;
        }

        UserDatabase database = new UserDatabase();
        String hashedPassword = Hashing.hashPassword(password);

        boolean success = database.addUser(email, username, hashedPassword);
        if (success) {
            System.out.println("Signup successful.");
            User user= database.getUser(email);
            FeedApplication feed = new FeedApplication(user);
            Stage stage= (Stage) emailField.getScene().getWindow();
            feed.start(stage);
        } else {
            System.out.println("Email already exists.");
        }
    }
}










