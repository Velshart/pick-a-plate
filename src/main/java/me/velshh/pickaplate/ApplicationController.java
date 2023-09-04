package me.velshh.pickaplate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ApplicationController {

    @FXML
    private TextArea englishPlates;

    @FXML
    private TextArea polishPlates;

    @FXML
    private TextField userInput;

    @FXML
    private Button generateButton;

    @FXML
    private CheckBox generatePolishPlates;

    @FXML
    private CheckBox generateEnglishPlates;

}