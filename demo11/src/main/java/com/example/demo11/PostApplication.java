package com.example.demo11;

import BackendUser.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PostApplication extends Application {
    private User user;
    public PostApplication(User user) {
    this.user=user;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PostApplication.class.getResource("hello-view.fxml"));
        Parent root=fxmlLoader.load();
        PostController controller= fxmlLoader.getController();
        controller.setUser(user);
        Scene scene = new Scene(root);
        stage.setTitle("Add Post");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}