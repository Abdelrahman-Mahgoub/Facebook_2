package com.example.demo11;

import Backend.Content;
import Backend.SaveContent;
import BackendFriends.Database;
import BackendFriends.Friend;
import BackendUser.User;
import BackendUser.UserDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class NotficationController {
    @FXML
    private VBox vbox;
    private User user;
    private Database friendlist;
    private List<User> users;
    @FXML
    public void setUser(User user){
        this.user=user;
    }
    @FXML
    public void add(){
        users=new ArrayList<>();
        UserDatabase userDatabase=new UserDatabase();
        users=userDatabase.returnall();
        friendlist= new Database();
        friendlist.loadContent();
        for(int i=0; i< users.size();i++){
            if(friendlist.hasfriendreq(users.get(i).getUsername(),user.getUsername(),"Pending")){
                Text text = new Text("You got a friend request from " + users.get(i).getUsername());
                Button Accept= new Button("Accept");
                Button Decline = new Button("Decline");
                vbox.getChildren().add(Accept);
                vbox.getChildren().add(Decline);
                vbox.getChildren().add(text);
                User geded= users.get(i);
                Accept.setOnAction(e -> Accept(geded));
                Decline.setOnAction(e -> Decline(geded));
            } else if (friendlist.arefriends(users.get(i).getUsername(),user.getUsername())||friendlist.arefriends(user.getUsername(),users.get(i).getUsername())) {
                SaveContent save = new SaveContent();
              ArrayList<Content>  contents= save.returnall();
                for(int j=0 ; j<contents.size();j++){
                    if(contents.get(j).getAuthorID().equals(users.get(i).getUsername())){
                        Text txt= new Text("A new post from your friend " + users.get(i).getUsername());
                        vbox.getChildren().add(txt);
                    }
                }
            }
        }
    }
    @FXML
    private void Accept(User friend){
        Friend friends = new Friend(user.getUsername(),friend.getUsername());
        friendlist.save(friends);
        friendlist.deletefriendreq(friend.getUsername(),user.getUsername());
    }
    @FXML
    private void Decline(User friend){
        friendlist.deletefriendreq(friend.getUsername(),user.getUsername());
    }
}
