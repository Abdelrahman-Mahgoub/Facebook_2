package com.example.demo11;

import BackendUser.User;
import BackendUser.UserDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class profilemanagcontroller {
    @FXML
    ImageView cover;
    User user;
    @FXML
    ImageView Profile;
    @FXML
    Label welcomeText;
    @FXML
    protected void changecover(ActionEvent event){
        try {
            FileChooser f = new FileChooser();
            Window stage =cover.getScene().getWindow();
            File tmp= f.showOpenDialog(stage);
            Image image = new Image(tmp.getAbsolutePath());
            cover.setImage(image);
            user.setCoverimg(tmp.getAbsolutePath());

        }
        catch (Exception e){
            welcomeText.setText("error");
        }
    }
    @FXML
    protected void profile(){
        try {
            FileChooser f = new FileChooser();
            Window stage =Profile.getScene().getWindow();
            File tmp= f.showOpenDialog(stage);
            Image image = new Image(tmp.getAbsolutePath());
            Profile.setImage(image);
            user.setProfileimg(tmp.getAbsolutePath());

        }
        catch (Exception e){
            welcomeText.setText("error");
        }
    }
    @FXML
    protected void update(ActionEvent event){
        UserDatabase database = new UserDatabase();
        database.updateProfile(user.getEmail(),null,user.getCoverimg(),user.getProfileimg() );
        database.save();
    }
    public void setUser(User user){
        this.user=user;
    }
}
