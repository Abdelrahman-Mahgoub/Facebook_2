package com.example.demo11;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {
    public void handleLogin() throws Exception {
        Stage stage = Main.getPrimaryStage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        stage.setScene(new Scene(loader.load()));
    }

    public void handleSignup() throws Exception {
        Stage stage = Main.getPrimaryStage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Signup.fxml"));
        stage.setScene(new Scene(loader.load()));
    }
}

