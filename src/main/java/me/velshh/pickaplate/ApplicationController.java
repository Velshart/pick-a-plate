package me.velshh.pickaplate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ApplicationController {

    @FXML
    private TextArea englishPlates;

    @FXML
    private TextArea polishPlates;

    @FXML
    private TextField userInputTextField;

    @FXML
    private Button generateButton;

    @FXML
    private CheckBox generatePolishPlates;

    @FXML
    private CheckBox generateEnglishPlates;

    @FXML
    protected void userInputTextFieldOnKeyReleased(KeyEvent keyEvent) {
        if(keyEvent.getCode() != KeyCode.BACK_SPACE) {
            userInputTextField.setText(userInputTextField.getText().toUpperCase());
            userInputTextField.setEditable(false);
        }
    }

    @FXML
    protected void userInputTextFieldOnKeyPressed(KeyEvent keyEvent) {
        if(userInputTextField.getText().length() == 1) {
            if(keyEvent.getCode() != KeyCode.BACK_SPACE) {
                userInputTextField.setEditable(false);
            }else {
                userInputTextField.clear();
                userInputTextField.setEditable(true);
            }
        }
    }
}