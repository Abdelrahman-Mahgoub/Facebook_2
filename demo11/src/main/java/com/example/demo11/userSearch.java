package com.example.demo11;

import BackendUser.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class userSearch extends Application {
private User user;
private User searched;

    public userSearch( User user,User searched) {
        this.searched = searched;
        this.user = user;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(userSearch.class.getResource("userFound.fxml"));
        Parent root=fxmlLoader.load();
        userSearchController controller = fxmlLoader.getController();
        controller.setUser(user);
        controller.setSearched(searched);
        controller.add();
        Scene scene = new Scene(root);
        primaryStage.setTitle("search");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
