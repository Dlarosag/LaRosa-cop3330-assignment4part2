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
    private TextField date;

    @FXML
    private TextField description;

    @FXML
    private TextField ItemName;

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
