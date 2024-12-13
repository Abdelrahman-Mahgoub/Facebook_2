package com.example.demo11;

import Backend.SaveContent;
import Backend.Story;
import BackendUser.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StoryController {
    @FXML
    private TextField text;
    @FXML
    private Label errors;
    @FXML
    private ImageView img;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    private User user;
    private int id =1000;
    Story d = new Story(String.valueOf(id),"1000","s");
    public StoryController() {
        JSONParser parser = new JSONParser();
        try {
            FileReader read = new FileReader("content.json");
            JSONArray load = (JSONArray) parser.parse(read);
            JSONObject object =(JSONObject) load.get(0);
            String contentID = (String) object.get("Content id");
            id=Integer.parseInt(contentID);
            id++;

        }    catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }
    @FXML

    protected void PostStory(ActionEvent event) {
        try{
            String s = text.getText();
            if(s==""){
                errors.setText("error");
            }
            else{
                d.setContent(text.getText());
                d.setAuthorID(user.getUsername());
                d.setContentID(String.valueOf(id));
                id++;
                SaveContent save = new SaveContent();
                save.save(d);
                FeedApplication feed = new FeedApplication(user);
                Stage stage= (Stage) text.getScene().getWindow();
                feed.start(stage);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }}
    @FXML
    protected void addpic(){
       try {
           FileChooser f = new FileChooser();
           Window stage =img.getScene().getWindow();
           File tmp= f.showOpenDialog(stage);
           Image image = new Image(tmp.getAbsolutePath());
           img.setImage(image);
           d.setImage(tmp.getAbsolutePath());
       }
       catch (Exception e){
errors.setText("error");
       }
    }
    public void setUser(User user){
        this.user=user;
    }
}
