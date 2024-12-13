package com.example.demo11;

import BackendUser.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GroupAct extends Application {
User user;

    public GroupAct(User user) {
        this.user = user;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FriendApplication.class.getResource("GroupAct.fxml"));
        Parent root=fxmlLoader.load();

       GroupActController controller = fxmlLoader.getController();
        controller.setUser(user);
        controller.add();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Group act");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
