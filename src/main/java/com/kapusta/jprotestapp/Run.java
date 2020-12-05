package com.kapusta.jprotestapp;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.kapusta.jprotestapp.config.DIModuleConfiguration;
import com.kapusta.jprotestapp.controller.MainSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;

public class Run extends Application {

    @Override
    public void start(Stage stage) {
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("scene-templates/main-scene.fxml"));
        Injector injector = Guice.createInjector(new DIModuleConfiguration());
        MainSceneController mainSceneController = injector.getInstance(MainSceneController.class);
        loader.setController(mainSceneController);

        Parent root = null;
        try {
             root = (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(root);
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        JMetro jMetro = new JMetro(Style.LIGHT);
        jMetro.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
