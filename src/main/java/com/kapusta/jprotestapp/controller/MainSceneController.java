package com.kapusta.jprotestapp.controller;

import com.google.inject.Inject;
import com.kapusta.jprotestapp.service.Counter;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainSceneController implements Initializable {

    @Inject
    private Counter counter;

    @Inject
    private HelpSceneController helpSceneController;

    @FXML
    public Label mainLabel;

    @FXML
    public Button mainButton;

    @FXML
    public AnchorPane helpPane;



    @FXML
    public void clickButton(Event e) {
        counter.increment();
    }

    @FXML
    public void help(Event e) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("scene-templates/help-scene.fxml"));
            loader.setController(helpSceneController);
            helpPane.getChildren().setAll(
                    (AnchorPane) loader.load());
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        counter.onIncrement(() -> {
            mainLabel.setText(counter.getCurrentValue());
            return null;
        });
    }
}
