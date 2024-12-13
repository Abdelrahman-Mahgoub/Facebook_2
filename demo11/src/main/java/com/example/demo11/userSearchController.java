package com.example.demo11;

import Backend.Content;
import Backend.SaveContent;
import BackendFriends.Database;
import BackendFriends.Friend;
import BackendFriends.FriendRequest;
import BackendUser.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class userSearchController {
    @FXML
    private VBox vbox;
    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    ImageView cover;
    @FXML
    ImageView profile;
    private User user;
    private User searched;
    private Database friendlist= new Database();
    public void setUser(User user){
        this.user=user;
    }
public void setSearched(User searched){
        this.searched=searched;
}
@FXML
void add(){

    SaveContent save = new SaveContent();
    ArrayList<Content>  contents=save.returnall();
Image imaGe= new Image(searched.getCoverimg());
cover.setImage(imaGe);
Image img= new Image(searched.getProfileimg());
profile.setImage(img);
        label.setText(searched.getUsername());
     if(searched.getUsername().equals(user.getUsername())){
         button.setText("you");
     }
else if(friendlist.hasfriendreq(user.getUsername(),searched.getUsername(),"Pending")){
button.setText("Pending");
button.setOnAction(cancelreq());
}
else if(friendlist.hasfriendreq(searched.getUsername(),user.getUsername(),"Pending")){
    button.setText("Accept");
         button.setOnAction(event -> Acceptreq());
}
else if(friendlist.arefriends(user.getUsername(),searched.getUsername())|| friendlist.arefriends(searched.getUsername(),user.getUsername())){
    button.setText("remove");
         button.setOnAction(event -> removefriend());
}
else {
    button.setText("Add");
         button.setOnAction(event -> sendreq());
}

        for(int i=0 ;i<contents.size();i++){
            if(contents.get(i).getAuthorID().equals(searched.getUsername())){
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
                }
            }
        }
}
@FXML
    protected EventHandler<ActionEvent> cancelreq(){
        friendlist.deletefriendreq(user.getUsername(),searched.getUsername());
    return null;
}
    @FXML
    protected EventHandler<ActionEvent> Acceptreq(){
        Friend friends = new Friend(user.getUsername(),searched.getUsername());
        friendlist.save(friends);
        friendlist.deletefriendreq(searched.getUsername(),user.getUsername());
        return null;
    }
    @FXML
    protected EventHandler<ActionEvent> removefriend(){
        friendlist.deletefriends(user.getUsername(),searched.getUsername());
        return null;
    }
    @FXML
    protected EventHandler<ActionEvent> sendreq(){
        FriendRequest request = new FriendRequest(user.getUsername(),searched.getUsername());
        friendlist.save(request);
        return null;
    }
}
