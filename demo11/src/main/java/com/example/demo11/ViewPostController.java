package com.example.demo11;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViewPostController {
@FXML
    private Label name;
@FXML
    private Label date;
    @FXML
    private Label type;
    @FXML
    private ImageView img;

    public void setName(String Name) {
        this.name.setText(Name);

    }

    public void setDate(String date) {
        this.date.setText(date);
    }

    public void setImg(String img) {
        Image image = new Image(img);
        this.img.setImage(image);
    }

    public void setType(String type) {
        this.type.setText(type);
    }
}
