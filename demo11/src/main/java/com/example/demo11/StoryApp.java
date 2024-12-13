package com.example.demo11;

import BackendUser.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StoryApp extends Application {
    private User user;
    public StoryApp(User user) {
        this.user=user;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PostApplication.class.getResource("Story.fxml"));
        Parent root=fxmlLoader.load();
        StoryController controller= fxmlLoader.getController();
        controller.setUser(user);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Add Post");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


}
