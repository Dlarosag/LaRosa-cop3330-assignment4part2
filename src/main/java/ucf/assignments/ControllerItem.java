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

public class ControllerItem {

    item newItem = new item();

    @FXML
    private Button Confirm;

    @FXML
    TextField date;

    @FXML
    TextField description;

    @FXML
    TextField ItemName;

    @FXML
    void confirm(ActionEvent event) {

        String itemTitle = ItemName.getText();
        String itemDate = date.getText();
        String itemDescription = description.getText();

        newItem.item(itemTitle, itemDescription, itemDate);

        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.close();
    }
}
