package com.example.demo11;

import BackendUser.Hashing;
import BackendUser.User;
import BackendUser.UserDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label messageLabel;
    private Stage stage;
    private Scene scene;
    private UserDatabase userDatabase;

    public LoginController() {
        userDatabase=new UserDatabase();
    }

    public void handleLogin(ActionEvent event) throws IOException {
        String email = emailField.getText();
        String password = passwordField.getText();
        UserDatabase db = new UserDatabase();
        String hashedPassword = Hashing.hashPassword(password);

        if (db.authenticate(email, hashedPassword) != null) {
            messageLabel.setText("Login Successful!");
User user= userDatabase.getUser(email);
            FeedApplication feed = new FeedApplication(user);
            Stage stage= (Stage) emailField.getScene().getWindow();
       feed.start(stage);

        } else {
            messageLabel.setText("Invalid email or password.");
        }
    }
}


