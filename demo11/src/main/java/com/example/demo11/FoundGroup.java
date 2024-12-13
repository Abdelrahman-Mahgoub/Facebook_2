package com.example.demo11;

import Backend.Group;
import BackendUser.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FoundGroup extends Application {
private User user;
private Backend.Group grp;
    public static void main(String[] args) {
        launch(args);
    }

    public FoundGroup(User user, Group grp) {
        this.user = user;
        this.grp = grp;
    }

    @Override
        public void start(Stage primaryStage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(FoundGroup.class.getResource("Found.grp.fxml"));
            Parent root=fxmlLoader.load();
           FoundGroupController controller = fxmlLoader.getController();
            controller.setUser(user);
            controller.setGrp(grp);
            controller.add();
            Scene scene = new Scene(root);
            primaryStage.setTitle("search");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

