package ucf.assignments;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable{

    private Stage stage;
    private Scene scene;
    private Parent root;
    private listOfList allList = new listOfList();

    @FXML
    private ChoiceBox<String> display;
    ObservableList showDisplay = FXCollections.observableArrayList();

    @FXML
    private Button doneButton;

    @FXML
    private Button Help;

    @FXML
    private Button exportList;

    @FXML
    private Button importList;

    @FXML
    private Button itemDelete;

    @FXML
    private Button newItem;

    @FXML
    private Button newList;

    @FXML
    private Button saveList;

    @FXML
    private Label listNameDisplay;

    @FXML
    private Label completionDisplay;

    @FXML
    private Label dateDisplay;

    @FXML
    private Label descrptDisplay;

    @FXML
    private Button editItem;

    @FXML
    void ItemEdit(ActionEvent event) {

        try {

            int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
            int j = allList.getList(i).findItemIndex(itemView.getSelectionModel().getSelectedItem());


            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/newItem.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            ControllerItem cI = fxmlLoader.getController();

            cI.newItem = allList.getList(i).getItem(j);

            cI.ItemName.setText(cI.newItem.getName());
            cI.description.setText(cI.newItem.getDescript());
            cI.date.setText(cI.newItem.getDate());

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.showAndWait();



            allList.getList(i).deleteItem(j);
            itemView.getItems().remove(j);

            allList.getList(i).addItem(cI.newItem);
            itemView.getItems().add(cI.newItem.getName());

            itemView.refresh();
            listView.refresh();




        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }

    }


    @FXML
    void deleteItem(ActionEvent event) {

        try {
            int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
            int j = allList.getList(i).findItemIndex(itemView.getSelectionModel().getSelectedItem());

            itemView.getItems().remove(j);

            allList.getList(i).deleteItem(j);
        }catch (Exception e){}
    }


    @FXML
    private ListView<String> listView;

    void addList(toDoList newList){

             listView.getItems().add(newList.getTitle());
             allList.addList(newList);
    }

    @FXML
    private ListView<String> itemView;

    void addItem(item newItem){

        int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
        allList.getList(i).addItem(newItem);
        itemView.getItems().add(newItem.getName());
    }

    @FXML
    void setDone(ActionEvent event) {

        int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());
        int j = allList.getList(i).findItemIndex(itemView.getSelectionModel().getSelectedItem());

        allList.getList(i).getItem(j).done();
        completionDisplay.setText("Done!");

    }



    @FXML
    void newListWindow(ActionEvent event) throws IOException {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/newList.fxml"));
            Parent root = (Parent) fxmlLoader.load();


            ControllerList cl = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
            addList(cl.newList);





        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }


    }

    @FXML
    void newItemWindow(ActionEvent event) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/newItem.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();

            ControllerItem cI = fxmlLoader.getController();

            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.showAndWait();

           addItem(cI.newItem);


        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }




    }



    @FXML
    void loadData(){

        showDisplay.addAll("To-Do", "All", "Completed");
        display.getItems().addAll(showDisplay);
        display.getSelectionModel().select(0);


    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadData();

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {



                int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());

                if(i > -1) {

                    listNameDisplay.setText(allList.getList(i).getTitle());
                    newItem.setDisable(false);
                    doneButton.setDisable(false);
                    itemDelete.setDisable(false);
                    editItem.setDisable(false);


                        itemView.getItems().clear();

                        for (int j = 0; j < allList.getList(i).getAmtItems(); j++) {
                            itemView.getItems().add(allList.getList(i).getItem(j).getName());
                    }

                }
            }
        });

        itemView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                try{

                int i = allList.findListIndex(listView.getSelectionModel().getSelectedItem());

                int j = allList.getList(i).findItemIndex(itemView.getSelectionModel().getSelectedItem());

                System.out.println(j);

                if(j > -1) {

                    descrptDisplay.setText(allList.getList(i).getItem(j).getDescript());
                    dateDisplay.setText(allList.getList(i).getItem(j).getDate());

                    if(allList.getList(i).getItem(j).isDone()){

                        completionDisplay.setText("Done!");
                    }

                    else{

                        completionDisplay.setText("To Do");
                    }





                }}catch(Exception e){}
            }

        });


    }
}

