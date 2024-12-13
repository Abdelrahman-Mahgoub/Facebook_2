package com.example.demo11;

import BackendFriends.Database;
import BackendFriends.Friend;
import BackendFriends.FriendRequest;
import BackendUser.User;
import BackendUser.UserDatabase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class FriendsController{
    @FXML
    private VBox contentsContainer;
    @FXML
    private VBox Suggestions;
    @FXML
    private VBox Friends;
    private ScrollPane scroll;
  private Database friendlist;
 private List<User> users;
private User user;


@FXML
    public void add() {
        users=new ArrayList<>();
        UserDatabase userDatabase=new UserDatabase();
        users=userDatabase.returnall();
        friendlist= new Database();
        friendlist.loadContent();
        for(int i=0; i< users.size();i++){
            if(users.get(i).getUserId().equals(user.getUserId())){
                continue;
            }
      else if(friendlist.hasfriendreq(users.get(i).getUsername(),user.getUsername(),"Pending")){
                Text text= new Text(users.get(i).username);
                Button Accept= new Button("Accept");
                Button Decline = new Button("Decline");
                contentsContainer.getChildren().add(text);
                contentsContainer.getChildren().add(Accept);
                contentsContainer.getChildren().add(Decline);
           User geded= users.get(i);
           Accept.setOnAction(e -> Accept(geded));
                Accept.setOnAction(e -> Accept(geded));
                Decline.setOnAction(e -> Decline(geded));
            }
      else if(friendlist.arefriends(users.get(i).getUsername(),user.getUsername())||friendlist.arefriends(user.getUsername(),users.get(i).getUsername())){
                Text text= new Text(users.get(i).username);
Friends.getChildren().add(text);
            }
            else {
                Text text= new Text(users.get(i).username);
                Button Add= new Button("Add");
                Suggestions.getChildren().add(text);
                Suggestions.getChildren().add(Add);
                User geded= users.get(i);
                Add.setOnAction(e -> sendFriendRequest(geded));

            }
        }
    }
    @FXML
    private void sendFriendRequest(User friend) {
        FriendRequest request= new FriendRequest(user.getUsername(),friend.getUsername());
        friendlist.save(request);
    }
    @FXML
    public void setUser(User user){
        this.user=user;
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
