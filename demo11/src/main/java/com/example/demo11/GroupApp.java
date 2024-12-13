package com.example.demo11;

import BackendUser.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GroupApp extends Application {
private User user;

    public GroupApp(User user) {
        this.user = user;
    }

    public static void main(String[] args) {
        launch(args);
    }

        @Override
        public void start(Stage primaryStage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(GroupApp.class.getResource("Group.fxml"));
            Parent root=fxmlLoader.load();

            groupController controller = fxmlLoader.getController();
            controller.setUser(user);

            Scene scene = new Scene(root);
            primaryStage.setTitle("Add group");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
}
