/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 David La Rosa Giraud
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerImport {

    String name;

    @FXML
    private Button confirm;

    @FXML
    private TextField fileName;

    @FXML
    void exitScreen(ActionEvent event) {

        name = fileName.getText();

        Stage stage = (Stage) confirm.getScene().getWindow();
        stage.close();
    }
}
