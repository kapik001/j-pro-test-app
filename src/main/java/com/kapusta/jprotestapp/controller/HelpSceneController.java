package com.kapusta.jprotestapp.controller;

import com.kapusta.jprotestapp.service.Counter;
import javafx.event.Event;
import javafx.fxml.FXML;

import javax.inject.Inject;

public class HelpSceneController {

    @Inject
    private Counter counter;


    @FXML
    public void helpOnMouse(Event event){
        counter.increment();
    }
}
