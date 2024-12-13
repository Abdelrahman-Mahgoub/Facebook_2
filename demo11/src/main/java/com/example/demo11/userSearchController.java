package com.example.demo11;

import Backend.Content;
import Backend.SaveContent;
import BackendUser.User;
import javafx.fxml.FXML;
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
    private User user;
    private User searched;
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

        label.setText(searched.getUsername());
        for(int i=0 ;i<contents.size();i++){
            if(contents.get(i).getAuthorID().equals(searched.getUsername())){
                if(contents.get(i).getImage()!=null) {
                    Text name = new Text(contents.get(i).getAuthorID());
                    Image img = new Image(contents.get(i).getImage());
                    ImageView image = new ImageView(img);
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

}
