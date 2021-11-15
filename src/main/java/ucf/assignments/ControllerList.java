package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerList {

    toDoList newList = new toDoList();

    @FXML
    private Button Confirm;

    @FXML
    TextField listName;

    @FXML
    public void confirm(ActionEvent event){

        String str = listName.getText();
        newList.editTitle(str);

        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.close();

    }


}
