package com.example.demo11;

import BackendUser.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FeedApplication extends Application {
    private User user;
    public FeedApplication(User user) {
       this.user=user;

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        try {
            FXMLLoader fxmlLoader =new  FXMLLoader(getClass().getResource("feed.fxml"));
Parent root=fxmlLoader.load();
FeedController controller= fxmlLoader.getController();
controller.setUser(user);
            primaryStage.setTitle("Feed");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
