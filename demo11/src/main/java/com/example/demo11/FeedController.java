package com.example.demo11;

import Backend.Content;
import Backend.SaveContent;
import BackendUser.User;
import BackendUser.UserDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FeedController implements Initializable {

    @FXML
    private VBox contentsContainer;
private ScrollPane scroll;
    private SaveContent save= new SaveContent();
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

            save.loadContent();
save.removeExpired();
            ArrayList<Content> contents= save.returnall();
            for(int i=0; i<contents.size();i++){
             VBox vbox = new VBox();





                if(contents.get(i).getImage()==null){
                    Text text = new Text("Name: "+contents.get(i).getAuthorID() + "\n" +"Date: "+ contents.get(i).getTime() +"\n");
                    vbox.getChildren().add(text);

                    Text write= new Text("\n" + contents.get(i).getContent() +"\n");
                    vbox.getChildren().add(write);
                }
                else {
                    Text text = new Text(contents.get(i).getAuthorID() + "\n" + contents.get(i).getTime() +"\n");
                    vbox.getChildren().add(text);
                    Image img = new Image(contents.get(i).getImage());
                    ImageView  image= new ImageView(img);
                    vbox.getChildren().add(image);
                    Text write= new Text("\n" + contents.get(i).getContent()+ "\n");
                    vbox.getChildren().add(write);

                }
contentsContainer.getChildren().add(vbox);
            }

        }


    @FXML
    private Label name;
    @FXML
        private Label errors;
    @FXML
    private TextField search;
    private Stage stage;
    private Scene scene;
    private Parent parent;
//to pass the user
    private User user;
    @FXML
    protected void NewPost(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        PostApplication post= new PostApplication(user);
    post.start(stage);
    }
    @FXML
    protected void NewStory(ActionEvent event) throws IOException {

        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
      StoryApp story = new StoryApp(user);
      story.start(stage);

    }
public void setUser(User user){
        this.user=user;
        name.setText(user.username);
}
public void logout(){
        UserDatabase userDatabase= new UserDatabase();
        userDatabase.loadUsers();
        userDatabase.logout(user);
        userDatabase.save();
        Stage stage= (Stage) name.getScene().getWindow();
        stage.close();
}
@FXML
    protected void Friends(ActionEvent event) throws IOException {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    FriendApplication post= new FriendApplication(user);
    post.start(stage);
}
@FXML
protected void  Notfi(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Notfications post= new Notfications(user);
        post.start(stage);
    }

   @FXML
protected void search(ActionEvent event) throws IOException {
    UserDatabase database = new UserDatabase();
    List<User> users = database.returnall();
    boolean userFound = false; 

    for (int i = 0; i < users.size(); i++) {
        if (search.getText().equals(users.get(i).getUsername())) {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            userSearch search = new userSearch(user, users.get(i));
            search.start(stage);
            userFound = true;
            break; 
        }
    }

    if (userFound) {
        errors.setText("User found");
    } else {
        errors.setText("User not found");
    }
}


}
