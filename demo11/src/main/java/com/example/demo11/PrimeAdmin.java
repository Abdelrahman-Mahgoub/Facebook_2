package com.example.demo11;

import Backend.Group;
import BackendUser.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PrimeAdmin extends Application {
    private User user;
    private Backend.Group grp;
    public PrimeAdmin(User user, Group grp) {
        this.user = user;
        this.grp = grp;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrimeAdmin.class.getResource("GroupPrimAdmin.fxml"));
        Parent root=fxmlLoader.load();
        PrimeAdminController controller = fxmlLoader.getController();
        controller.setUser(user);
        controller.setGrp(grp);
        controller.add();
        Scene scene = new Scene(root);
        primaryStage.setTitle("GroupPrimAdmin.fxml");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
