package com.example.demo11;

import Backend.Content;
import Backend.Group;
import Backend.GroupDatabase;
import Backend.SaveContent;
import BackendUser.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class FoundGroupController {
    private User user;
    private Group grp;
@FXML
private VBox vbox;
@FXML
private Button button;
private GroupDatabase groupDatabase=new GroupDatabase();
 public void setUser(User user){
     this.user=user;
 }
    public void setGrp(Group grp){
        this.grp=grp;
    }
    @FXML
    public void add(){
        SaveContent database=new SaveContent();
        int l=0;
        List<Content> contents= database.returnall();
        for(int i=0; i<contents.size();i++){
        if(grp.getName().equals(contents.get(i).getAuthorID())){
            if(contents.get(i).getImage()!=null) {
                Text name = new Text(contents.get(i).getAuthorID());
                Image iMg = new Image(contents.get(i).getImage());
                ImageView image = new ImageView(iMg);
                String time = String.valueOf(contents.get(i).getTime());
                Text date = new Text(time);
                Text post = new Text(contents.get(i).getContent());
                vbox.getChildren().add(name);
                vbox.getChildren().add(date);
                vbox.getChildren().add(image);
                vbox.getChildren().add(post);
            }
            else {
                Text name = new Text(contents.get(i).getAuthorID());
                String time = String.valueOf(contents.get(i).getTime());
                Text date = new Text(time);
                Text post = new Text(contents.get(i).getContent());
                vbox.getChildren().add(name);
                vbox.getChildren().add(date);

                vbox.getChildren().add(post);
            }}
        if(grp.getPrimaryAdmin().equals(user.getUsername())){
            button.setText("delete");
            button.setOnAction(event -> deleteGroup());
        }
        else {
            List<String> members = grp.getMembers();
            for (int j = 0; j < members.size(); j++) {

                if (members.get(j).equals(user.getUsername())) {
                    button.setText("leave");
                    button.setOnAction(event -> leave());
                    l = 1;

                }
            }
            if (l == 0) {
                button.setText("join");
                button.setOnAction(event -> joingrp());
            }
        }
        }

}
public void deleteGroup(){
     GroupDatabase database= new GroupDatabase();
     database.removeGroup(grp.getName());
     database.Save();
}
public void leave(){
    GroupDatabase database= new GroupDatabase();
    grp.removeMember(user.getUsername());
    database.Save();
}
    @FXML
    protected void joingrp(){
        grp.addMember(user.getUsername());
        groupDatabase.Save();
    }
}
