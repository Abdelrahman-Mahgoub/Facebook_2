package com.example.demo11;

import Backend.Group;
import Backend.GroupDatabase;
import BackendUser.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GroupActController {
    private User user;
    public void setUser(User user){
        this.user=user;
    }
    @FXML
    VBox vBox;
    @FXML
    public void add(){
        GroupDatabase database= new GroupDatabase();
        database.loadGroups();
      List<Group> groups= database.returnall();
        for(int i=0;i <groups.size();i++){
            if(groups.get(i).searchMember(user.getUsername())){
                Text text= new Text(groups.get(i).getName());
                Button addpost = new Button("AddPost");
                vBox.getChildren().add(text);
                vBox.getChildren().add(addpost);
                Group currentGroup = groups.get(i);
                addpost.setOnAction(event -> {
                    try {
                        addpost(event, currentGroup);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                if(currentGroup.getPrimaryAdmin().equals(user.getUsername())){
                    Button primactions= new Button("PrimActions");
                    vBox.getChildren().add(primactions);

                   primactions.setOnAction(event -> {
                        try {
                            getprimeActions(event, currentGroup);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
                else if(groups.get(i).searchAdmin(user.getUsername())){
                    Button actions= new Button("Actions");
                    vBox.getChildren().add(actions);
                }
            }
        }
    }
    @FXML
    protected void addpost(ActionEvent event,Group grp) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        PostApplication post= new PostApplication(user,grp);
        post.start(stage);
    }
    @FXML
    protected void getprimeActions(ActionEvent event, Group grp) throws IOException {
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        PrimeAdmin post= new PrimeAdmin(user,grp);
        post.start(stage);
    }
}
