package com.example.demo11;

import Backend.Group;
import Backend.GroupDatabase;
import BackendUser.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class groupController {
    private User user;
    public void setUser(User user){
        this.user=user;
    }
    @FXML
    TextField name;
    @FXML
    TextField des;
    @FXML
    ImageView img;
    @FXML
    protected void addGroup(ActionEvent event) throws IOException {
        String nme= name.getText();
        String description= des.getText();
        GroupDatabase  data= new GroupDatabase();
        Group group= new Group(nme,description,user.getUsername());
       data.addGroup(group);
        FeedApplication feed = new FeedApplication(user);
        Stage stage= (Stage) name.getScene().getWindow();
        feed.start(stage);
    }
}
