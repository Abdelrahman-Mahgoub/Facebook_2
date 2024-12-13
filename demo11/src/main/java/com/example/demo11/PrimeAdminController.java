package com.example.demo11;

import Backend.Group;
import Backend.GroupDatabase;
import BackendUser.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class PrimeAdminController {
    private User user;
    private Group grp;
    @FXML
    private VBox vBox;
    private GroupDatabase database= new GroupDatabase();
    public void setUser(User user){
        this.user=user;
    }
    public void setGrp(Group grp){
        this.grp=grp;
    }
    @FXML
    public void add(){
        List<String> members =grp.getMembers();
        for (int i=0; i<members.size();i++){
            if(user.getUsername().equals(members.get(i))){
                continue;
            }
            Text name= new Text(members.get(i));
            Button remove = new Button("remove");
            String membr =members.get(i);
            remove.setOnAction(event -> remove(membr));
            vBox.getChildren().add(name);
            vBox.getChildren().add(remove);
            if(grp.searchAdmin(members.get(i))){
                Button denote= new Button("denote");
                vBox.getChildren().add(denote);
            }
            else {
                String member= members.get(i);
                Button promote = new Button("promote");
                promote.setOnAction(event -> Promote(member));
                vBox.getChildren().add(promote);

            }

        }
    }
@FXML
    protected void delete(){
        database.removeGroup(grp.getName());
    }
@FXML
    protected void Promote(String member){
        grp.addAdmin(member);
        database.Save();
    }
@FXML
    protected void remove(String member){
        grp.removeMember(member);
        database.Save();
    }
}
